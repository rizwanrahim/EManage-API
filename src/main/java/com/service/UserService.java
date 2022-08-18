package com.service;

import com.entity.User;
import com.service.repo.UserRepo;
import com.shared.AppResponse;
import com.shared.AppService;
import com.shared.exception.NotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class UserService extends AppService<Long, User, UserRepo> implements UserDetailsService {

    public UserService(UserRepo userRepo) {
        super(userRepo);
    }

    public User findByUsername(String name) {
        return this.repo.findByUsername(name).orElse(null);
    }

    @Override
    public AppResponse<User> Save(User e) {
        e.setPassword(passwordEncoder().encode(e.getPassword()));
        return super.Save(e);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.repo.findByUsername(username)
                .orElseThrow(() -> new NotFoundException("User not found"));

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), authorities);
    }
}
