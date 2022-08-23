package com.neosoft.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

//we can use @Data annotaion but its providing hashcode,tostring ,equals,getter and setter also but we want only getter&setter
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    //@OneToOne(cascade = CascadeType.ALL)
    private Department department;

    @Temporal(value = TemporalType.DATE)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date date;

    @UpdateTimestamp
    private LocalDateTime updateddate;

    @CreationTimestamp
    private LocalDateTime createddate;

}
//bean class file ,pojo