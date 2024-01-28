package com.school_server.payload;

import com.school_server.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class readStudentDTO {
    private List<Student> student;
    private String message;

}
