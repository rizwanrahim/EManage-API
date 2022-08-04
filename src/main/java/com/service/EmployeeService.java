package com.service;

import com.generic.GenericService;
import com.entity.Employee;
import com.repo.EmployeeRepo;
import com.repo.RoleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service @Transactional
public class EmployeeService extends GenericService<Long, Employee, EmployeeRepo> {
    private final RoleRepo roleRepo;

    public EmployeeService(EmployeeRepo employeeRepo, RoleRepo roleRepo) {
        super(employeeRepo);
        this.roleRepo = roleRepo;
    }

    public boolean addRoleToUser(String username, String roleName) {
        var employee = this.repo.findByUsername(username);
        var role = roleRepo.findByName(roleName);
        return employee.getRoles().add(role);
    }
}
