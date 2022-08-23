package com.neosoft.repository;

import com.neosoft.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
//    here long is type and employee is entity
}
