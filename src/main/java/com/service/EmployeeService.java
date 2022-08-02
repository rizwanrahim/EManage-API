package com.service;

import com.exception.UserNotFoundException;
import com.model.Employee;
import com.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo repo;

    @Autowired
    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public List<Employee> GetAll() {
        return repo.findAll();
    }
    public Employee Save(Employee employee) {
        repo.save(employee);
        return employee;
    }
    public Employee Find(Long id) {
        var result = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
        return result;
    }
}
