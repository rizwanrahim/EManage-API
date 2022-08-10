package com.validators;

import com.generic.AppResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Getter
public abstract class AppValidator<T> implements IAppValidator<T> {
    protected static final String CAN_NOT_BE_NULL_OR_EMPTY = " can not be null or empty";
    protected final List<String> errors = new ArrayList<>();
    protected <Res extends AppResponse> Res SetResponse(Res res) {
        if(!errors.isEmpty()) {
            res.setValidationMessage(errors);
            res.setValidated(false);
            res.setSucceded(false);
            return res;
        }

        res.setValidated(true);
        res.setSucceded(true);
        return res;
    }

    protected void IsNullOrEmpty(String field, String fieldName, List<String> errors) {
        if(field.trim().length() == 0 || field == null)
            errors.add(SetErroMessage(fieldName));
    }

    protected String SetErroMessage(String fieldName) {
        return fieldName + CAN_NOT_BE_NULL_OR_EMPTY;
    }
}
