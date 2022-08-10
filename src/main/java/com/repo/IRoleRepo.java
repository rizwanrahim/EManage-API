package com.repo;

import com.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepo extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
