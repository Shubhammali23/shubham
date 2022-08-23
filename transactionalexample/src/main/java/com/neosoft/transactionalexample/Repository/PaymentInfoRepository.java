package com.neosoft.transactionalexample.Repository;

import com.neosoft.transactionalexample.Entity.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {
}
