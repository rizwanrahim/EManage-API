package com.generic;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor @Setter @Getter
public class AppResponse<T> {
    private T response;
    private boolean isSucceded = true;
    private String  errorMessage;
    private boolean isValidated = true;
    private String validationMessage;
}
