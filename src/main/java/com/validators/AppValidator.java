package com.validators;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component @Getter
public abstract class AppValidator<T> implements IAppValidator<T> {
    protected final List<String> errors = new ArrayList<>();
}
