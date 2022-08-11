package com.shared;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@RequiredArgsConstructor @Setter @Getter
public class AppResponse<T> {
    private T response;
    private boolean isSucceded = true;
    private String  errorMessage;
    private boolean isValidated = true;
    private List<String> validationMessage;
}
