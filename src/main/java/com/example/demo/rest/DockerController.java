package com.example.demo.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping(value = "/docker/health",  method = RequestMethod.GET, produces = "text/plain")
    public String getHealthStatus(){
        return null;
    }
}
