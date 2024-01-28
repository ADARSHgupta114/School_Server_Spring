package com.school_server.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="teacher")
public class Teacher {
    @Id
    private long id;
    @NotEmpty
    private String name;
    private String DOJ;
    private String subject;
    private String gender;
    @Email
    private String email;
    private long mobile;
    private String salary;
    private String address;
}
