package com.service;

import com.exception.AppResponseService;
import com.generic.AppResponse;
import com.generic.AppService;
import com.entity.Employee;
import com.repo.IEmployeeRepo;
import com.repo.IRoleRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService extends AppService<Long, Employee, IEmployeeRepo> {
    private final IRoleRepo IRoleRepo;

    public EmployeeService(IEmployeeRepo IEmployeeRepo, IRoleRepo IRoleRepo) {
        super(IEmployeeRepo);
        this.IRoleRepo = IRoleRepo;
    }

    public AppResponse<Boolean> addRoleToUser(String username, String roleName) {
        return Run(res -> {
            var employee = this.repo.findByUsername(username);
            var role = IRoleRepo.findByName(roleName);
            var _return = employee.getRoles().add(role);
            res.setResponse(_return);
        });
    }
}
