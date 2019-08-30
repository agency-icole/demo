package com.example.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @RequestMapping(value = "/docker/health",  method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity getHealthStatus(){
        return new ResponseEntity( "Unregistered version!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
