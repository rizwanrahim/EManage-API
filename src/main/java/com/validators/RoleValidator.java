package com.validators;

import com.entity.Role;
import com.generic.AppResponse;

public class RoleValidator extends AppValidator<Role> {

    @Override
    public <X> AppResponse<X> valid(Role obj, AppResponse<X> res) {
        errors.clear();
        IsNullOrEmpty(obj.getName(), "Role Name", errors);
        return SetResponse(res);
    }
}
