package com.example.demo.rest;

import com.example.demo.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DockerController {

    @Autowired
    RegisterService registerService;

    private boolean isRegistered(){
        return registerService.isRegistered();
    }

    @RequestMapping(value = "/docker/health",  method = RequestMethod.GET, produces = "text/plain")
    public ResponseEntity getHealthStatus(){
        if(isRegistered())
            return  new ResponseEntity(HttpStatus.OK);
        return new ResponseEntity( "Unregistered version!", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
