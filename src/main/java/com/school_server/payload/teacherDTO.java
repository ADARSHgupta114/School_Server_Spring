package com.school_server.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class teacherDTO {
    private long id;
    private String name;
    private String DOJ;
    private String subject;
    private String gender;
    private long mobile;
    private String salary;
    private String address;
    private String email;
}
