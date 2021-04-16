package com.example.emillab;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping(path = "/")
public class TestController {

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/moto")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String welcome_hello(){
        return "hello from the other side";
    }
}
