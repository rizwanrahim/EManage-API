package com.controller;

import com.generic.AppController;
import com.entity.Employee;
import com.generic.AppResponse;
import com.model.UserRole;
import com.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/employee")
public class EmployeeController extends AppController<Employee, EmployeeService> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<AppResponse<Boolean>> AddRoleToUser(@RequestBody UserRole userRole) {
        var result = this.service.addRoleToUser(userRole);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}
