package com.service;

import com.generic.GenericService;
import com.model.Employee;
import com.model.Role;
import com.repo.EmployeeRepo;
import com.repo.RoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Long, Role, RoleRepo> {
    public RoleService(RoleRepo roleRepo) {
        super(roleRepo);
    }
}
