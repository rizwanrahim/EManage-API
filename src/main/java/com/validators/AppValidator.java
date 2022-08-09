package com.validators;

import com.generic.AppResponse;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Getter
public abstract class AppValidator<T> implements IAppValidator<T> {
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
}
