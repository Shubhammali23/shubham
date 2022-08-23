package com.neosoft.thymeleaflogin.repository;

import com.neosoft.thymeleaflogin.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
}
