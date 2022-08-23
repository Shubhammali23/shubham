package com.neosoft.transactional.repository;

import com.neosoft.transactional.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
