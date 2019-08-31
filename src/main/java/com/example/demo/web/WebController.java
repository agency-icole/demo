package com.example.demo.web;

import com.example.demo.service.RegisterService;
import com.example.demo.web.form.RegistrationForm;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.ValidationException;
import java.util.concurrent.TimeUnit;

@Controller
public class WebController {


    @Autowired
    MeterRegistry meterRegistry;

    @Autowired
    RegisterService registerService;

    @RequestMapping("/")
    @Timed
    public String index(){
        Timer timer = Timer.builder("demo_rest")
                .tag("special","test")
                .register(meterRegistry);
        timer.record(()->{

        });
        return "default";
    }
    @RequestMapping("/register")
    @Timed
    public String register(Model model){
        model.addAttribute("page","register");
        model.addAttribute("registrationForm", new RegistrationForm());
        return "default";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Model model, @ModelAttribute RegistrationForm registrationForm) {
        try {
            registerService.register(registrationForm.getName(), registrationForm.getEmail());
            model.addAttribute("registered", "true");
        } catch (ValidationException e) {
            model.addAttribute("page", "register");
            model.addAttribute("error", e.getMessage());
        }
        return "default";
    }
}
