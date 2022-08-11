package com.service.validation;

import com.entity.Role;
import com.shared.AppResponse;
import com.shared.validators.AppValidator;

public class RoleValidator extends AppValidator<Role> {

    @Override
    public <X> AppResponse<X> valid(Role obj, AppResponse<X> res) {
        errors.clear();
        IsNullOrEmpty(obj.getName(), "Role Name", errors);
        return SetResponse(res);
    }
}
