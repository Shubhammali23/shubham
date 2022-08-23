package com.neosoft.transactionalexample.Dto;

import com.neosoft.transactionalexample.Entity.PassengerInfo;
import com.neosoft.transactionalexample.Entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FlightBookingRequest {

    //@Autowired
    private PassengerInfo passengerInfo;

   // @Autowired
    private PaymentInfo paymentInfo;
}
