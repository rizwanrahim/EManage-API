package com.emanage.emanage;

import com.EmployeeResource;
import com.model.Employee;
import com.repo.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = EmployeeResource.class)
@EntityScan(basePackageClasses = Employee.class)
@EnableJpaRepositories(basePackageClasses = EmployeeRepo.class)
public class EmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmanageApplication.class, args);
	}

}
