package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectDetailPage {

    @Autowired
    private ProjectService projectService;

    @ModelAttribute("project")
    public Project project() {
        return new Project();
    }

    @GetMapping("/projectDetailPage/{id}")
    public String showProjectDetailPage(@PathVariable("id") int projectId, Model model){
        Project project = projectService.findProjectById(projectId);
        model.addAttribute("project", project);
        return "views/projectDetailPage";
    }
}
