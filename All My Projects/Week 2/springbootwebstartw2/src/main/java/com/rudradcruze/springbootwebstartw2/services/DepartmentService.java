package com.rudradcruze.springbootwebstartw2.services;

import com.rudradcruze.springbootwebstartw2.dto.DepartmentDTO;
import com.rudradcruze.springbootwebstartw2.entities.DepartmentEntity;
import com.rudradcruze.springbootwebstartw2.exception.ResourceNotFoundException;
import com.rudradcruze.springbootwebstartw2.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<DepartmentDTO> getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }

    public List<DepartmentDTO> getAllDepartments() {
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        return departmentEntities.stream()
                .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .toList();
    }

    public DepartmentDTO createDepartment(DepartmentDTO inputDepartment) {
        return modelMapper.map(departmentRepository.save(modelMapper.map(inputDepartment, DepartmentEntity.class)), DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartmentById( DepartmentDTO departmentDTO, Long departmentId) {
        isDepartmentExistById(departmentId);

        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);
        departmentEntity.setId(departmentId);
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }

    public void isDepartmentExistById(Long departmentId) {
        boolean exist = departmentRepository.existsById(departmentId);
        if (!exist) throw new ResourceNotFoundException("Department not found with id: " + departmentId);
    }

    public boolean deleteDepartmentById(Long departmentId) {
        isDepartmentExistById(departmentId);
        departmentRepository.deleteById(departmentId);
        return true;
    }

    public DepartmentDTO updatePartialDepartmentById(Long departmentId, Map<String, Object> updates) {
        isDepartmentExistById(departmentId);

        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).get();
        updates.forEach((field, value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(DepartmentEntity.class, field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, departmentEntity, value);
        });
        return modelMapper.map(departmentRepository.save(departmentEntity), DepartmentDTO.class);
    }
}
