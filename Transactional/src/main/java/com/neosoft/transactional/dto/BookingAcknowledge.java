package com.neosoft.transactional.dto;

import com.neosoft.transactional.entity.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingAcknowledge {
    private double totalfare;
    private Passenger passenger;
}
