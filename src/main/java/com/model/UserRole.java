package com.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Getter @Setter @NoArgsConstructor
public class UserRole {
    private String username;
    private String role;
}
