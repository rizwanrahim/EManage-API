package com.service;

import com.exception.NotFoundException;
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
import java.util.Optional;

@Service
@Transactional
public class EmployeeService extends AppService<Long, Employee, IEmployeeRepo> {

    private final IRoleRepo IRoleRepo;
    private final IAppValidator<UserRole> userRoleAppValidator;

    public EmployeeService(
            IEmployeeRepo IEmployeeRepo,
            IRoleRepo IRoleRepo,
            IAppValidator<UserRole> userRoleAppValidator,
            IAppValidator<Employee> employeeIAppValidator) {
        super(IEmployeeRepo);
        this.IRoleRepo = IRoleRepo;
        this.userRoleAppValidator = userRoleAppValidator;
        this.validator = employeeIAppValidator;
    }

    public AppResponse<Boolean> addRoleToUser(UserRole userRole) {
           return Run(res -> {
               userRoleAppValidator.valid(userRole, res);
               if(res.isValidated()) {
                   var employee = this.repo
                           .findByUsername(userRole.getUsername())
                           .orElseThrow(() -> new NotFoundException("Employee not found"));
                   var role = IRoleRepo
                           .findByName(userRole.getRole())
                           .orElseThrow(() -> new NotFoundException("Role not found"));
                   var _return = employee
                           .getRoles().add(role);

                   res.setResponse(_return);
               }
           });
    }
}
