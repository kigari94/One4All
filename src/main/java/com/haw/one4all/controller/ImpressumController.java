package com.haw.one4all.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ImpressumController {

    @GetMapping("/impressum")
    public String showImpressum() {
        return "views/impressum";
    }
}