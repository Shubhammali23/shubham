package com.neosoft.transactionalexample.Repository;

import com.neosoft.transactionalexample.Entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoRepository extends JpaRepository<PassengerInfo, Long> {
}
