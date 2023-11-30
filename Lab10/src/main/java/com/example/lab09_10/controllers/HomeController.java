package com.example.lab09_10.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String helloUser() {
        return "user";
    }

    @GetMapping("/admins")
    public String helloAdmin() {
        return "admin";
    }
}
