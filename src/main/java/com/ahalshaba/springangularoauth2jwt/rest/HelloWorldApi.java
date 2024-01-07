package com.ahalshaba.springangularoauth2jwt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahalshaba.springangularoauth2jwt.dto.Personne;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HelloWorldApi {


    @GetMapping(value="/hello_user", produces="application/json")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Personne> HelloWorldUser(){
       Personne p = new Personne();
        p.setName("USER");
        p.setType("user");
        p.setMessage("Hello user");
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @GetMapping(value="/hello_admin",produces="application/json")
    @PreAuthorize("hasAuthority('ADMIN')")
    public  ResponseEntity<Personne>  HelloWorldAdmin(){
        Personne p = new Personne();
        p.setName("ADMIN");
        p.setType("admin");
        p.setMessage("Hello admin");
        return new ResponseEntity<>(p,HttpStatus.OK);
    }

}
