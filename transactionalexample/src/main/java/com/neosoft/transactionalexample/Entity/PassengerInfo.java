package com.neosoft.transactionalexample.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PassengerInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pId;

    //@Column
    private String name;

    //@Column
    private String email;
    //@Column
    private String source;

    //@Column
    private String destination;

    //@Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private Date travelDate;

    //@Column
    private String pickUpTime;

    //@Column
    private String arrivalTime;

    //@Column
    private double fare;
}
