package com.shared.exception;

import com.shared.AppResponse;
import com.shared.validators.IAppValidator;


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

    protected  final <T> AppResponse<T> Run(RegisterAppResponse<T> reg, IAppValidator<T> validator, AppResponse<T> app) {
        validator.valid(app.getResponse(), app);
        return Run(reg);
    }

    @FunctionalInterface
    protected interface RegisterAppResponse<T>
    {
        void invoke(AppResponse<T> config);
    }
}
