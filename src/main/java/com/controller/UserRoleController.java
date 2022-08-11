package com.controller;

import com.model.UserRole;
import com.service.UserRoleService;
import com.shared.AppResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRoleController {

    private final UserRoleService service;

    public UserRoleController(UserRoleService service) {
        this.service = service;
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<AppResponse<Boolean>> AddRoleToUser(@RequestBody UserRole userRole) {
        var result = service.addRoleToUser(userRole);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }
}
