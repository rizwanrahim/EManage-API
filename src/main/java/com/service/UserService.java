package com.service;

import com.entity.User;
import com.service.repo.UserRepo;
import com.shared.AppService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService extends AppService<Long, User, UserRepo> {

    public UserService(UserRepo userRepo) {
        super(userRepo);
    }
}
