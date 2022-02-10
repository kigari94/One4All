package com.haw.one4all.controller;

import com.haw.one4all.Model.User;
import com.haw.one4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/register")
    public String showRegistration() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "views/registration";
        }

        return "redirect:/";
    }

    @PostMapping("/register")
    public String processRegister(@Valid User user, BindingResult result) {
        // Validating password match
        if (user.getPassword() != null && user.getConfirmPassword() != null) {
            if (!user.getPassword().equals(user.getConfirmPassword())) {
                result.addError(new FieldError("user", "confirmPassword", "Bitte gib dein Passwort erneut an."));
            }
        }
        // Validating field values
        if (result.hasErrors()) {
            return "views/registration";
        }

        userService.saveUser(user);
        return "redirect:/?success";

    }
}