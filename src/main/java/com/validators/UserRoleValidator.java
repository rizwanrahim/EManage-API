package com.validators;

import com.generic.AppResponse;
import com.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserRoleValidator extends AppValidator<UserRole> {
    @Override
    public <TReturn> AppResponse<TReturn> valid(UserRole obj, AppResponse<TReturn> res) {
        errors.clear();
        if(obj.getUsername() == null ||
            obj.getUsername().trim().length() == 0)
            errors.add("Username cannot be null or empty");

        if(obj.getRole() == null ||
                obj.getRole().trim().length() == 0)
            errors.add("Role cannot be null or empty");

        return SetResponse(res);
    }

}
