package com.neosoft.roleslogin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    public void saveUserWithDefaultRole(User user) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        String encodedPassword=encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        Role roleUser = roleRepo.findByName("User");
        user.addRole(roleUser);
        userRepo.save(user);
    }

}