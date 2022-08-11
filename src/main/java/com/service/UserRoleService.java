package com.service;

import com.model.UserRole;
import com.service.repo.RoleRepo;
import com.service.repo.UserRepo;
import com.shared.AppResponse;
import com.shared.exception.AppResponseService;
import com.shared.exception.NotFoundException;
import com.shared.validators.IAppValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleService extends AppResponseService {

    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
    private final IAppValidator<UserRole> userRoleAppValidator;

    public UserRoleService(RoleRepo roleRepo,
                           UserRepo userRepo,
                           IAppValidator<UserRole> userRoleAppValidator) {
        this.roleRepo = roleRepo;
        this.userRepo = userRepo;
        this.userRoleAppValidator = userRoleAppValidator;
    }

    public AppResponse<Boolean> addRoleToUser(UserRole userRole) {
        return Run(res -> {
            userRoleAppValidator.valid(userRole, res);
            if(res.isValidated()) {
                var user = userRepo
                        .findByUsername(userRole.getUsername())
                        .orElseThrow(() -> new NotFoundException("Employee not found"));
                var role = roleRepo
                        .findByName(userRole.getRole())
                        .orElseThrow(() -> new NotFoundException("Role not found"));
                var _return = user
                        .getRoles().add(role);

                res.setResponse(_return);
            }
        });
    }
}
