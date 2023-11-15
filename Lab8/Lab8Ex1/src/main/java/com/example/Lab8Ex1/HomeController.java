package com.example.Lab8Ex1;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
        @GetMapping("/Contact")
        public String contact(Model m){
            UserModel user = new UserModel();
            m.addAttribute("User",user);
            return "contact";
        }
        @PostMapping("/Contact")
        public String FormContact(UserModel userModel,Model m){
            m.addAttribute("User",userModel);
            return "contact";
        }

        @GetMapping("/About")
    public String AboutPage(){
            return "About this site";
        }

}
