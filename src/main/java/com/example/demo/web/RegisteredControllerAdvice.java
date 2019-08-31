package com.example.demo.web;

import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class RegisteredControllerAdvice {

    @Autowired
    RegisterService registerService;

    @ModelAttribute("registered")
    public boolean isRegistered(){
        return registerService.isRegistered();
    }
}
