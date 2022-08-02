package com.controller;

import com.model.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> GetAll() {
        return new ResponseEntity(service.GetAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Employee> Save(@RequestBody Employee employee) {
        var result = service.Save(employee);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    @GetMapping("/find/{id}")
    public  ResponseEntity<Employee> Find(@PathVariable("id") Long Id) {
        var result = service.Find(Id);
        return new ResponseEntity(result, HttpStatus.OK);
    }
}
