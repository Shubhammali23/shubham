package com.example.demo.signup.web;

import com.example.demo.signup.model.Role;
import com.example.demo.signup.model.User;
import com.example.demo.signup.repository.RoleRepository;
import com.example.demo.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String admin(Model model) {
        model.addAttribute("admins", userRepository.findAll());
        return "adminindex";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "adminlogin";
    }

    @GetMapping("/shownewEmployeeform")
    public String shownewEmployeeform(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
        this.userRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Error"));

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        model.addAttribute("user", user);
        return "update_user";
    }
//    @GetMapping("/update_user")
//    public String update_user(@PathVariable(value="id") long id){
//        this.userRepository.save(id);
//        return "redirect:/";
//    }

}
