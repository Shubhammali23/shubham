// Building get all employees rest api
package com.neosoft.controller;

import com.neosoft.entity.Employee;
import com.neosoft.repository.EmployeeRepository;
import com.neosoft.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin("*")
@RestController
@RequestMapping(path = "/employee")
//so this class is capable to handle http request
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp) {
        return employeeRepository.save(emp);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        return ResponseEntity.ok(emp);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        updateEmployee.setName(employeeDetails.getName());
        updateEmployee.setDate(employeeDetails.getDate());
        updateEmployee.setDepartment(employeeDetails.getDepartment());
//        updateEmployee.setCreateddate(employeeDetails.getCreateddate());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id:" + id));
        employeeRepository.delete(emp);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
