package com.rudradcruze.springbootwebstartw2.repositories;

import com.rudradcruze.springbootwebstartw2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

}
