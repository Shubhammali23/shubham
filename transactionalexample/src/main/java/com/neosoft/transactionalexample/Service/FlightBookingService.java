package com.neosoft.transactionalexample.Service;

import com.neosoft.transactionalexample.Dto.FlightBookingAcknowledgement;
import com.neosoft.transactionalexample.Dto.FlightBookingRequest;
import com.neosoft.transactionalexample.Entity.PassengerInfo;
import com.neosoft.transactionalexample.Entity.PaymentInfo;
import com.neosoft.transactionalexample.Repository.PassengerInfoRepository;
import com.neosoft.transactionalexample.Repository.PaymentInfoRepository;
import com.neosoft.transactionalexample.Utils.PaymentUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FlightBookingService
{
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    public FlightBookingAcknowledgement bookingRequest(FlightBookingRequest request)
    {
        //FlightBookingAcknowledgement acknowledgement;

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo =request.getPaymentInfo();
        PaymentUtil.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("Success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
