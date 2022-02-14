package com.haw.one4all.controller;

import com.haw.one4all.Model.User;
import com.haw.one4all.repository.UserRepository;
import com.haw.one4all.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepo;

    @ModelAttribute("user")
    public User user() {
        return new User();
    }

    @GetMapping("/login")
    public String showLogin() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "views/login";
        }

        return "redirect:/";
    }



//        @GetMapping("/login")
//
//        public ModelAndView login() {
//            ModelAndView mav = new ModelAndView("login");
//            mav.addObject("user", new User());
//            return mav;
//        }

        @PostMapping("/home")
        public String login(@ModelAttribute("user") User user ) {

            User oauthUser = UserService.login(user.getUsername(), user.getPassword());

            System.out.print(oauthUser);
            if(Objects.nonNull(oauthUser))
            {
                return "redirect:/home";

            } else {
                return "redirect:/home";
            }
        }

        @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
        public String logoutDo(HttpServletRequest request, HttpServletResponse response)
        {


            return "redirect:/login";
        }

    }



//    @PostMapping("/process_login")
//    public String processRegister(User user) {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//
//        userRepo.save(user);
//
//        return "redirect:/projectPage";
//    }



