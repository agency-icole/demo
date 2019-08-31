package com.example.demo.web;

import com.example.demo.service.RegisterService;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String register(){
        registerService.register();
        return "default";
    }
}
