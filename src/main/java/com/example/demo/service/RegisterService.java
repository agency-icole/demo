package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.regex.Pattern;

@Service
public class RegisterService {

    boolean registered = false;
    String name;
    String email;
    Long timestamp;

    public static String EMAiL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    public static Pattern EMAiL_PATTERN = Pattern.compile(EMAiL_REGEX);

    public void register(String name, String email) throws ValidationException {
        validate(name,email);
        this.name=name.trim();
        this.email=email.trim();
        this.timestamp=System.currentTimeMillis();
        this.registered = true;
    }

    public void validate(String name, String email) throws ValidationException{
       if(name==null||name.trim().equals(""))
            throw new ValidationException("Please provide your full name!");
        if(name.trim().indexOf(" ")<0)
            throw new ValidationException("Please provide your full name including first and last name!");
        if(email==null||email.trim().equals("")||!EMAiL_PATTERN.matcher(email).find())
            throw new ValidationException("Please provide valid email!");
    }
    public boolean isRegistered(){
        return registered;
    }
}
