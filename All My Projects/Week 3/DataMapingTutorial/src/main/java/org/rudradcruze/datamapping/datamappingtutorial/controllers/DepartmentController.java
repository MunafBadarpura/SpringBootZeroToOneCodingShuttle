package org.rudradcruze.datamapping.datamappingtutorial.controllers;

import org.rudradcruze.datamapping.datamappingtutorial.entities.DepartmentEntity;
import org.rudradcruze.datamapping.datamappingtutorial.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return departmentService.createNewDepartment(departmentEntity);
    }

    @PutMapping("/{departmentId}/manager/{employeeId}")
    private DepartmentEntity assignManagerToDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId
        ) {
        return departmentService.assignManagerToDepartment(departmentId, employeeId);
    }

    @GetMapping("/assignedDepartmentOfManager/{employeeId}")
    public DepartmentEntity getAssignedDepartmentOfManager(@PathVariable Long employeeId) {
        return departmentService.getAssignedDepartmentOfManager(employeeId);
    }

    @PutMapping("/{departmentId}/worker/{employeeId}")
    private DepartmentEntity assignWorkerToDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId
    ) {
        return departmentService.assignWorkerToDepartment(departmentId, employeeId);
    }

    @PutMapping("/{departmentId}/freelancer/{employeeId}")
    private DepartmentEntity assignFreelancerToDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long employeeId
    ) {
        return departmentService.assignFreelancerToDepartment(departmentId, employeeId);
    }
}
