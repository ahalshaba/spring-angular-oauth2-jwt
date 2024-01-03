package com.ahalshaba.springangularoauth2jwt.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldApi {


    @GetMapping("/hello_user")
    public String HelloWorldUser(){
        return "Hello from user";
    }
    @GetMapping("/hello_admin")
    public String  HelloWorldAdmin(){
        return "Hello from admin";
    }

}
