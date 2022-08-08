package com.validators;

import java.util.List;
public interface IAppValidator<T> {
    boolean valid(T obj);
    List<String> getErrors();
}
