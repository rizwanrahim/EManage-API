package com.emanage.emanage;

import com.entity.Role;
import com.entity.User;
import com.model.UserRole;
import com.service.RoleService;
import com.service.UserRoleService;
import com.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@SpringBootApplication
@ComponentScan({"com.service", "com.controller", "com.service.validation"})
@EntityScan({"com.entity"})
@EnableJpaRepositories({"com.service.repo"})
public class EmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmanageApplication.class, args);
	}

	@Bean
	CommandLineRunner run(
			UserService userService,
			UserRoleService userRoleService,
			RoleService roleService) {
		return args -> {
			roleService.Save(new Role(null, "SUPER_ADMIN"));
			userService.Save(new User(
					null,
					"Super Admin",
					"superadmin@emanage.com",
					"",
					"superadmin",
					"superadmin",
					null));

			userRoleService.addRoleToUser(new UserRole(
					"superadmin",
					"SUPER_ADMIN"));
		};
	}
}
