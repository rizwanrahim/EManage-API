package com.service;

import com.entity.Role;
import com.service.repo.RoleRepo;
import com.shared.AppService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AppService<Long, Role, RoleRepo> {
    public RoleService(RoleRepo RoleRepo) {
        super(RoleRepo);
    }
    public Role findByName(String name) {
        return this.repo.findByName(name).orElse(null);
    }
}
