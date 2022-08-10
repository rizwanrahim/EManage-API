package com.validators;

import antlr.StringUtils;
import com.entity.Employee;
import com.generic.AppResponse;
import com.model.UserRole;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator extends AppValidator<Employee> {
    @Override
    public <X> AppResponse<X> valid(Employee obj, AppResponse<X> res) {
        errors.clear();
        IsNullOrEmpty(obj.getName(), "Name", errors);
        IsNullOrEmpty(obj.getUsername(), "Username", errors);

        if(obj.getUsername().contains(" "))
            errors.add("Username should not contain space in between");

        return SetResponse(res);
    }
}
