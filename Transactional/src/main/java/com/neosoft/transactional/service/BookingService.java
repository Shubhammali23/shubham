package com.neosoft.transactional.service;

import com.neosoft.transactional.dto.Booking;
import com.neosoft.transactional.dto.BookingAcknowledge;
import com.neosoft.transactional.entity.Passenger;
import com.neosoft.transactional.entity.Payment;
import com.neosoft.transactional.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neosoft.transactional.repository.PassengerRepository;
import com.neosoft.transactional.repository.PaymentRepository;

//import java.util.UUID;

@Service
public class BookingService {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public BookingAcknowledge bookTicket(Booking request) {
       // BookingAcknowledge acknowledge = null;
        Passenger passenger = request.getPassenger();
        passengerRepository.save(passenger);

        Payment payment = request.getPayment();
        paymentRepository.save(payment);
        PaymentUtils.validateCreditLimit(payment.getAccountNo(), passenger.getFare());
        payment.setPasengerId(passenger.getId());
        payment.setAmount(passenger.getFare());
        paymentRepository.save(payment);
        return new BookingAcknowledge(passenger.getFare(), passenger);
    }
}
