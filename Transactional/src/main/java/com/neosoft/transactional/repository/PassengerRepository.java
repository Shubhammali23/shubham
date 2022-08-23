package com.neosoft.transactional.repository;

import com.neosoft.transactional.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
