package com.controller;

import com.generic.GenericController;
import com.model.Employee;
import com.model.Role;
import com.service.EmployeeService;
import com.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController extends GenericController<Role, RoleService> {
    public RoleController(RoleService service) {
        super(service);
    }
}
