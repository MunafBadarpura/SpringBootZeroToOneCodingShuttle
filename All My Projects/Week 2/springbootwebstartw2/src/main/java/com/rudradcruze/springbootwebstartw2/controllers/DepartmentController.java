package com.rudradcruze.springbootwebstartw2.controllers;

import com.rudradcruze.springbootwebstartw2.dto.DepartmentDTO;
import com.rudradcruze.springbootwebstartw2.exception.ResourceNotFoundException;
import com.rudradcruze.springbootwebstartw2.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartment() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) {
        DepartmentDTO saveDepartment = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(saveDepartment, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartmentById(@RequestBody @Valid DepartmentDTO departmentDTO, @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.updateDepartmentById(departmentDTO, id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updatePartialEmployeeId(
            @RequestBody Map<String, Object> updates,
            @PathVariable Long id) {
        DepartmentDTO departmentDTO = departmentService.updatePartialDepartmentById(id, updates);
        if (departmentDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteDepartmentById(@PathVariable Long id) {
        boolean isDeleted = departmentService.deleteDepartmentById(id);
        if (!isDeleted) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(true);
    }
}
