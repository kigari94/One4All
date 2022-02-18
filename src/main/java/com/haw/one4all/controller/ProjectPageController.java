package com.haw.one4all.controller;
import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import com.haw.one4all.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
        // Validating field values
        if (result.hasErrors()) {
            return "views/projectPage";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        user.setUsername(authentication.getName());
        project.setUser(user);

        projectService.saveProject(project);
        return "redirect:/";

    }
}
