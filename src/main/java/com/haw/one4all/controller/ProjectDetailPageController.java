package com.haw.one4all.controller;

import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import com.haw.one4all.repository.UserRepository;
import com.haw.one4all.service.ProjectService;
import com.haw.one4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectDetailPageController {

    @Autowired
    private ProjectService projectService;
    private UserService userService;
    private UserRepository userRepo;

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


    @GetMapping("/projectDetailPage/favorite/{id}")
    public String favoriteProject(@PathVariable("id") int projectId){
    // Getting user data
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String authUser = SecurityContextHolder.getContext().getAuthentication().getName();
    Project project = projectService.findProjectById(projectId);

    // Validate logged in user
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
        return "redirect:/";
    }

    // add user to list of favorites
        projectService.addUserFavorite(project, authUser);

        for(int i=0; i < project.getUsersFavorite().size(); i++){
            System.out.println( project.getUsersFavorite().get(i) );
        }

        return "redirect:/";
    }


    @GetMapping("/projectDetailPage/delete/{id}")
    public String deleteProject(@PathVariable("id") int projectId){
        // Getting user data
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String authUser = SecurityContextHolder.getContext().getAuthentication().getName();
        Project project = projectService.findProjectById(projectId);

        // Validate logged in user
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken
                || !authUser.equals(project.getUser().getUsername())) {
            return "redirect:/";
        }

        // Delete project
        projectService.deleteProjectById(projectId);
        return "redirect:/";
    }
}
