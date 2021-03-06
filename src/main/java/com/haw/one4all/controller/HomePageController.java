package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @GetMapping("/#top")
    public String showHomeTop() {
        // returning home scrolled to top
       return "views/home" + "/#top";
    }

    @GetMapping("/{type}")
    public String showFilteredProjects(@PathVariable("type") String projectType, Model model) {
        // getting user data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // let a logged in user filter for their favorite projects
        if (projectType.equals("Favoriten")){
            List<Project> listProjects = projectService.findFavoriteProjects(username);
            Collections.reverse(listProjects);
            model.addAttribute("listProjects", listProjects);
            return "views/home";
        }
        // returning all projects matching the projectType on home with latest order
        List<Project> listProjects = projectService.findProjectsByType(projectType);
        Collections.reverse(listProjects);
        model.addAttribute("listProjects", listProjects);
        return "views/home";
    }
}