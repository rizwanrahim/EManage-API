package com.validators;

import com.generic.AppResponse;
import com.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class UserRoleValidator extends AppValidator<UserRole> {
    @Override
    public <TReturn> AppResponse<TReturn> valid(UserRole obj, AppResponse<TReturn> res) {
        errors.clear();
        IsNullOrEmpty(obj.getUsername(), "Username", errors);
        IsNullOrEmpty(obj.getRole(), "Role", errors);
        return SetResponse(res);
    }

}
