package com.example.lab09_10.controllers;

import com.example.lab09_10.models.Role;
import com.example.lab09_10.models.User;
import com.example.lab09_10.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class LearnSpringSecurityController {
    @Autowired
    UserService userService;

    @GetMapping("/my-login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }

    @GetMapping("/create")
    public String createUser() {
        // just for test
        Set<Role> roles = new HashSet<>();
        roles.add(new Role(1, "USER"));
        User user = new User("test", "test", "test", "test", true, roles);
        userService.register(user);
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        for (GrantedAuthority authority : userDetails.getAuthorities()) {
            if (authority.getAuthority().equals("USER")) {
                System.out.println("YOU HAVE ROLE USER");
            } else if (authority.getAuthority().equals("ADMIN")) {
                System.out.println("YOU HAVE ROLE ADMIN");
            } else {
                System.out.println("you dont have any roles");
            }
        }
        return "index";
    }
}
