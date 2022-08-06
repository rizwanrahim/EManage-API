package com.service;

import com.generic.AppService;
import com.entity.Role;
import com.repo.IRoleRepo;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AppService<Long, Role, IRoleRepo> {
    public RoleService(IRoleRepo IRoleRepo) {
        super(IRoleRepo);
    }
}
