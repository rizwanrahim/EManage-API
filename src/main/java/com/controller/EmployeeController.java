package com.controller;

import com.generic.GenericController;
import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends GenericController<Employee, EmployeeService> {

    public EmployeeController(EmployeeService service) {
        super(service);
    }
}
