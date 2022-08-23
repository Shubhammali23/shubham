package com.neosoft.thymeleaflogin.controller;

import com.neosoft.thymeleaflogin.entity.UserDetails;
import com.neosoft.thymeleaflogin.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@Controller
//@Component
public class UserController {
    @Autowired
    UserDetailsRepository userRepo;

    @GetMapping("/")
    public String home() {
        return "index";
    }
    @GetMapping("/sucess")
    public String sucess() {
        return "sucess";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute UserDetails u, HttpSession session) {
        System.out.println(u);
        userRepo.save(u);
        session.setAttribute("message", "user register sucessfully...");
        return "redirect:/";
    }
}