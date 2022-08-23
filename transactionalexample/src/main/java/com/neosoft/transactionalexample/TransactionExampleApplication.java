package com.neosoft.transactionalexample;

import com.neosoft.transactionalexample.Dto.FlightBookingAcknowledgement;
import com.neosoft.transactionalexample.Dto.FlightBookingRequest;
import com.neosoft.transactionalexample.Service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
//@RequestMapping("Booking")
public class TransactionExampleApplication {

	@Autowired
	private FlightBookingService service;

	@PostMapping("Booking")
	public FlightBookingAcknowledgement bookingRequest(@RequestBody FlightBookingRequest request)
	{
		return service.bookingRequest(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(TransactionExampleApplication.class, args);
	}

}