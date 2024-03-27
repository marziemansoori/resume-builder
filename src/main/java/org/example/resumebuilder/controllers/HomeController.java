package org.example.resumebuilder.controllers;


import org.example.resumebuilder.entities.UserProfile;
import org.example.resumebuilder.repositories.UserProfileRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class HomeController {

    final
    UserProfileRepository userProfileRepository;

    public HomeController(UserProfileRepository userProfileRepository) {
        this.userProfileRepository = userProfileRepository;
    }

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
        Optional<UserProfile> optionalUserProfile = userProfileRepository.findByUserName(userId);
        optionalUserProfile.orElseThrow(() -> new RuntimeException("Not found" + userId));

        UserProfile userProfile = optionalUserProfile.get();

        model.addAttribute("userId", userId);
        model.addAttribute("userProfile", userProfile);
        return "profile" + userProfile.getTheme();
    }
}
