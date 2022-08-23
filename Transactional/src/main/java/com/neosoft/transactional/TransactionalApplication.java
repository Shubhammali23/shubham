package com.neosoft.transactional;

import com.neosoft.transactional.dto.Booking;
import com.neosoft.transactional.dto.BookingAcknowledge;
import com.neosoft.transactional.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TransactionalApplication {
    @Autowired
    private BookingService service;

    @PostMapping("/bookFlightTicket")
    public BookingAcknowledge bookTicket(@RequestBody Booking request) {
        return service.bookTicket(request);
    }


    public static void main(String[] args) {
        SpringApplication.run(TransactionalApplication.class, args);
    }

}
