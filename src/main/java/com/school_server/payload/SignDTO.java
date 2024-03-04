package com.school_server.payload;

import lombok.Data;

import java.util.Set;

@Data
public class SignDTO {
    private String username;
    private String password;
    private Set<String> role;
}
