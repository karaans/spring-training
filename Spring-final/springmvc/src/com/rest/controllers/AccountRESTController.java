package com.rest.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class AccountRESTController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
    public String sayHello(@RequestParam String msg){
        return "Hello " + msg;
    }
}
