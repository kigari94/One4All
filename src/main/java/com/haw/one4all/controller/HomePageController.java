package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String showHome(Model model) {
        List<Project> listProjects = projectService.findProjects();
        model.addAttribute("listProjects", listProjects);
        return "views/home";
    }
}