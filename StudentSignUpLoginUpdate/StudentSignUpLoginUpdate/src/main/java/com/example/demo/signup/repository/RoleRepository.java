package com.example.demo.signup.repository;

import com.example.demo.signup.dto.web.UserRegistrationDto;
import com.example.demo.signup.model.Role;
import com.example.demo.signup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface RoleRepository extends JpaRepository<Role, Long> {

    interface UserService extends UserDetailsService {
        //    for edit for admin
        User getUserById(long id);

        void saveUser(User user);

        User save(UserRegistrationDto registrationDto);

        User updateUser(UserRegistrationDto updateUserRegistrationDto);
    }
}
