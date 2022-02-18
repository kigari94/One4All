package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import com.haw.one4all.service.ProjectInputFilter;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
public class ProjectPageController {

    @Autowired
    private ProjectService projectService;

    @ModelAttribute("project")
    public Project project() {
        return new Project();
    }

    @GetMapping("/projectPage")
    public String showProjectPage() {
        return "views/projectPage";
    }

    @PostMapping("/createProject")
    public String processRegister(@Valid Project project, BindingResult result, User user) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user.setUsername(authentication.getName());
        project.setUser(user);

        // check title inappropriate words
        if (!ProjectInputFilter.isValid(project.getTitle())) {
            result.addError(new FieldError("project", "title",
                    "Der Titel enthält unangebrachte oder anstößige Inhalte"));
        }

        // check description for inappropriate words
        if (!ProjectInputFilter.isValid(project.getDescription())) {
            result.addError(new FieldError("project", "description",
                    "Die Beschreibung enthält unangebrachte oder anstößige Inhalte"));
        }

        // checking crew for inappropriate words
        if (!ProjectInputFilter.isValid(project.getCrew())) {
            result.addError(new FieldError("project", "crew",
                    "Die Gewerke enthalten unangebrachte oder anstößige Inhalte"));
        }

        // Validating field values
        if (result.hasErrors()) {
            return "views/projectPage";
        }

        projectService.saveProject(project);
        return "redirect:/";
    }
}
