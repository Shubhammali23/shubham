package com.neosoft.controller;

import com.neosoft.entity.Department;
import com.neosoft.exception.ResourceNotFoundException;
import com.neosoft.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @PutMapping("{id}")
    public Department updateDepartment(@PathVariable long id, @RequestBody Department department) {
        Department dept = departmentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Does not exist"));
        dept.setName(department.getName());
        return departmentRepository.save(dept);
    }
}
