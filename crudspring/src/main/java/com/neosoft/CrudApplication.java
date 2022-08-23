package com.neosoft;

import com.neosoft.entity.Employee;
import com.neosoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;


@SpringBootApplication
public class CrudApplication implements CommandLineRunner {


    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);

    }

    //in commandlinerunner interface their is run method we have to override that
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        Employee emp1 = new Employee();
        emp1.setName("Shubham");
        emp1.setDate(Date.valueOf("1997-03-23"));
        employeeRepository.save(emp1);

        Employee emp2 = new Employee();
        emp2.setName("ram");
        //emp2.setDate("22-04-1997");
        emp2.setDate(Date.valueOf("1996-06-04"));
        employeeRepository.save(emp2);

        Employee emp3 = new Employee();
        emp3.setName("kaustubh");
        emp3.setDate(Date.valueOf("1990-07-01"));
        employeeRepository.save(emp3);

    }
}
