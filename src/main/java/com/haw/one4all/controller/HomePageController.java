package com.haw.one4all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomePageController {

    @GetMapping("/")
    public String home(@ModelAttribute("model") HomePageModel model) {
        model.setTitle("Test");
        return "view/home";
    }
}