package com.validators;

import com.generic.AppResponse;

import java.util.List;
public interface IAppValidator<T> {
    <X> AppResponse<X> valid(T obj, AppResponse<X> res);
    List<String> getErrors();
}
