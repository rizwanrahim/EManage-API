package com.service.validation;

import com.model.UserRole;
import com.shared.AppResponse;
import com.shared.validators.AppValidator;
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
