package com.skillmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skillmanager.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}