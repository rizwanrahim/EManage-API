package com.service;

import com.generic.AppResponse;
import com.generic.AppService;
import com.entity.Employee;
import com.model.UserRole;
import com.repo.IEmployeeRepo;
import com.repo.IRoleRepo;
import com.validators.IAppValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeService extends AppService<Long, Employee, IEmployeeRepo> {

    private final IRoleRepo IRoleRepo;
    private final IAppValidator<UserRole> userRoleAppValidator;

    public EmployeeService(
            IEmployeeRepo IEmployeeRepo,
            IRoleRepo IRoleRepo,
            IAppValidator<UserRole> userRoleAppValidator) {
        super(IEmployeeRepo);
        this.IRoleRepo = IRoleRepo;
        this.userRoleAppValidator = userRoleAppValidator;
    }

    public AppResponse<Boolean> addRoleToUser(UserRole userRole) {
        return Run(res -> {
            userRoleAppValidator.valid(userRole, res);
            if(res.isValidated()) {
                var employee = this.repo.findByUsername(userRole.getUsername());
                var role = IRoleRepo.findByName(userRole.getRole());
                var _return = employee.getRoles().add(role);
                res.setResponse(_return);
            }
        });
    }
}
