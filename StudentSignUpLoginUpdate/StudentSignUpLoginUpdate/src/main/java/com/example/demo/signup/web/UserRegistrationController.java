package com.example.demo.signup.web;

import com.example.demo.signup.dto.web.UserRegistrationDto;
import com.example.demo.signup.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private RoleRepository.UserService userService;

    @Autowired
    public UserRegistrationController(RoleRepository.UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @ModelAttribute("updateUser")
    public UserRegistrationDto updateUser() {
        return new UserRegistrationDto();
    }


    @GetMapping
    public String getRegistrationForm() {
        return "registration";
    }


    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.save(userRegistrationDto);
        return "redirect:/registration?success";
    }

    @PostMapping("/adminUpdate")
    public String registerUser(@ModelAttribute("user") UserRegistrationDto userRegistrationDto) {
        userService.updateUser(userRegistrationDto);
        return "redirect:/adminindex";
    }

}
