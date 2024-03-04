package com.school_server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class loginDTO {
    private String username;
    private String email;
    private String password;

}
