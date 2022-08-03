package com.service;

import com.exception.UserNotFoundException;
import com.generic.GenericService;
import com.model.Employee;
import com.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService extends GenericService<Long, Employee, EmployeeRepo> {

    public EmployeeService(EmployeeRepo employeeRepo) {
        super(employeeRepo);
    }
}
