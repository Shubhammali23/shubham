package com.example.demo.signup.service;

import com.example.demo.signup.dto.web.UserRegistrationDto;
import com.example.demo.signup.model.Role;
import com.example.demo.signup.model.User;
import com.example.demo.signup.repository.RoleRepository;
import com.example.demo.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements RoleRepository.UserService {

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
//    for edit for admin
@Override
public User getUserById(long id) {
    Optional<User> employee = userRepository.findById(id);
    System.out.print(employee);
    if (employee.isPresent()) {
        return employee.get();
    } else {
        throw new RuntimeException("No employee record exist for given id");
    }
}

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

//    end

    @Override
    public User save(UserRegistrationDto registrationDto) {

        User user = new User(registrationDto.getId(), registrationDto.getFirstName(), registrationDto.getLastName(), registrationDto.getEmail()
                , passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ADMIN_ROLE")));
        return userRepository.save(user);

    }

    @Override
    public User updateUser(UserRegistrationDto updateUserRegistrationDto) {
        User user = new User(updateUserRegistrationDto.getId(), updateUserRegistrationDto.getFirstName(),
                updateUserRegistrationDto.getLastName(), updateUserRegistrationDto.getEmail(), updateUserRegistrationDto.getPassword(), Arrays.asList(new Role("USER_ROLE")));
        return userRepository.save(user);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid UserName and Password");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesAuthoritiy(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesAuthoritiy(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
