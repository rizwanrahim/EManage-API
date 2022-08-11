package com.service.validation;

import com.entity.User;
import com.shared.AppResponse;
import com.shared.validators.AppValidator;
import org.springframework.stereotype.Component;

@Component
public class UserValidator extends AppValidator<User> {
    @Override
    public <X> AppResponse<X> valid(User obj, AppResponse<X> res) {
        errors.clear();
        IsNullOrEmpty(obj.getName(), "Name", errors);
        IsNullOrEmpty(obj.getUsername(), "Username", errors);

        if(obj.getUsername().contains(" "))
            errors.add("Username should not contain space in between");

        return SetResponse(res);
    }
}
