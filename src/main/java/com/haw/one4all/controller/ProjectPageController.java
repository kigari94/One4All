package com.haw.one4all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProjectPageController {

    @GetMapping("/projectPage")
    public String showHome() {
        return "views/projectPage";
    }
}
