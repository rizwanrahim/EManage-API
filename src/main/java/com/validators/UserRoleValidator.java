package com.validators;

import com.model.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter @Component
public class UserRoleValidator implements IAppValidator<UserRole> {
    private final List<String> errors = new ArrayList<>();

    @Override
    public boolean valid(UserRole obj) {
        errors.clear();
        if(obj.getUsername() == null ||
            obj.getUsername().trim().length() == 0)
            errors.add("Username cannot be null or empty");

        if(obj.getRole() == null ||
                obj.getRole().trim().length() == 0)
            errors.add("Role cannot be null or empty");

        if(errors.isEmpty())
            return true;

        return false;
    }

}
