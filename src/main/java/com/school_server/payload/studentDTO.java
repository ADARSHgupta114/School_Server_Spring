package com.school_server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class studentDTO {
    private long id;
    private String name;
    private long mobile;
    private String email;
    private String standard;
    private String father;
    private String mother;
    private String gender;
    private String DOB;
    private String address;
    private String DOA;
}
