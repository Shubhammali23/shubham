package com.neosoft.transactional.dto;

import com.neosoft.transactional.entity.Passenger;
import com.neosoft.transactional.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Booking {
    private Passenger passenger;
    private Payment payment;
}
