package org.example.resumebuilder.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Home Page";
    }


    @GetMapping("/edit")
    public String edit() {
        return "Edit page";
    }

    @GetMapping("/profile/{userId}")
    public String profile(@PathVariable String userId, Model model) {
        model.addAttribute("userId", userId);
        return "profile2";
    }
}
