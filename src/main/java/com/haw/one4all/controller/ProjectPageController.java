package com.haw.one4all.controller;
import com.haw.one4all.Model.Project;
import com.haw.one4all.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ProjectPageController {

    @ModelAttribute("project")
    public Project project() {
        return new Projects();
    }

    @GetMapping("/projectPage")
    public String showHome() {
        return "views/projectPage";
    }

    @PostMapping("/createProject")
    public String processRegister(@Valid Project project, BindingResult result) {
        // Validating field values
        if (result.hasErrors()) {
            return "views/registration";
        }

        userService.saveUser(user);
        return "redirect:/";

    }
}
