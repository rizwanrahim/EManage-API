package com.controller;

import com.generic.AppController;
import com.entity.Role;
import com.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends AppController<Role, RoleService> {
    public RoleController(RoleService service) {
        super(service);
    }
}
