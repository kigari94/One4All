package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collections;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/")
    public String showHome(Model model) {
        // returning all projects on home with latest order
        List<Project> listProjects = projectService.findProjects();
        Collections.reverse(listProjects);
        model.addAttribute("listProjects", listProjects);
        return "views/home";
    }

    @GetMapping("/{type}")
    public String showFilteredProjects(@PathVariable("type") String projectType, Model model) {
        // returning all projects matching the projectType on home with latest order
        List<Project> listProjects = projectService.findProjectsByType(projectType);
        Collections.reverse(listProjects);
        model.addAttribute("listProjects", listProjects);
        return "views/home";
    }
}