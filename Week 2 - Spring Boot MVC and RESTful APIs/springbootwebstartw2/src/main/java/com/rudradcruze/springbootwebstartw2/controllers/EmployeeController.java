package com.rudradcruze.springbootwebstartw2.controllers;

import com.rudradcruze.springbootwebstartw2.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage() {
//        return "Secret message: asgjkas32351!@";
//    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Rudra", "francisrudra@gmail.com", 21, LocalDate.of(2024, 1, 2), true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi Rudra your age is: " + age + " " + sortBy;
    }

    @PostMapping
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeDTO.setId(100L);
        employeeDTO.setActive(true);
        return employeeDTO;
    }

    @PutMapping
    public String updateEmployee() {
        return "Employee updated successfully";
    }
}
