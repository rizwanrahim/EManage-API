package com.exception;

import com.entity.Employee;
import com.generic.AppResponse;

public class AppResponseService {
    protected  final <T> AppResponse<T> Run(RegisterAppResponse<T> reg) {
        var app = new AppResponse<T>();
        try {
            reg.invoke(app);
        } catch (Exception e) {
            app.setErrorMessage(e.getMessage());
        }
        return app;
    }

    @FunctionalInterface
    protected interface RegisterAppResponse<T>
    {
        void invoke(AppResponse<T> config);
    }
}
