package com.rudradcruze.springbootwebstartw2.controllers;

import com.rudradcruze.springbootwebstartw2.dto.EmployeeDTO;
import com.rudradcruze.springbootwebstartw2.entities.EmployeeEntity;
import com.rudradcruze.springbootwebstartw2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret message: asgjkas32351!@";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
//        return new EmployeeDTO(id, "Rudra", "francisrudra@gmail.com", 21, LocalDate.of(2024, 1, 2), true);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                                @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
        //        return "Hi Rudra your age is: " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
//        employeeDTO.setId(100L);
//        employeeDTO.setActive(true);
//        return employeeDTO;
        return employeeRepository.save(employeeEntity);
    }

    @PutMapping
    public String updateEmployee() {
        return "Employee updated successfully";
    }
}
