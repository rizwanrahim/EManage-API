package com.repo;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
}
