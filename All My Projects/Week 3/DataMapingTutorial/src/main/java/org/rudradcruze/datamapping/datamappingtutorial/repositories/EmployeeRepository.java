package org.rudradcruze.datamapping.datamappingtutorial.repositories;

import org.rudradcruze.datamapping.datamappingtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
