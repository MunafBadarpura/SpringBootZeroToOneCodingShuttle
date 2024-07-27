package org.rudradcruze.datamapping.datamappingtutorial.repositories;

import org.rudradcruze.datamapping.datamappingtutorial.entities.DepartmentEntity;
import org.rudradcruze.datamapping.datamappingtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);
}
