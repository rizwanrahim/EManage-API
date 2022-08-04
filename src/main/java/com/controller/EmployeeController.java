package com.controller;

import com.generic.GenericController;
import com.entity.Employee;
import com.model.UserRole;
import com.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends GenericController<Employee, EmployeeService> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<Boolean> Save(@RequestBody UserRole userRole) {
        var result = this.service.addRoleToUser(userRole.getUsername(), userRole.getRole());
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}
