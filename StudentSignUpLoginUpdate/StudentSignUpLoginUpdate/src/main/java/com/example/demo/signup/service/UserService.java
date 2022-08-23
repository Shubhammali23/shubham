package com.example.demo.signup.service;

import com.example.demo.signup.dto.web.UserRegistrationDto;
import com.example.demo.signup.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);

    User updateUser(UserRegistrationDto updateUserRegistrationDto);

    User getUserById(long id);
    void saveUser(User user);

}