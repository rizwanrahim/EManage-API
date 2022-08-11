package com.controller;

import com.entity.User;
import com.service.UserService;
import com.shared.AppController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController extends AppController<User, UserService> {

    public UserController(UserService service) {
        super(service);
    }


}
