package com.haw.one4all.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectPageController {

    @GetMapping("/Projektseite")
    public String showHome() {
        return "views/projectPage";
    }
}
