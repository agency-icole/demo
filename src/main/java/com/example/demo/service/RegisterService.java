package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    boolean registered = false;

    public void register(){
        this.registered = true;
    }

    public boolean isRegistered(){
        return registered;
    }
}
