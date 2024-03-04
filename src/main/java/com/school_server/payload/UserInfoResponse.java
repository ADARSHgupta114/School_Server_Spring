
package com.school_server.payload;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String username;
    private String password;
    private List<String> roles;

    public UserInfoResponse(Long id, String username,String password, List<String> roles) {
        this.id = id;
        this.password=password;
        this.username = username;
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
