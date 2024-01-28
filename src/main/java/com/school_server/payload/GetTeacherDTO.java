package com.school_server.payload;

import com.school_server.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTeacherDTO {
    private List<Teacher> teacher;
    private String message;
}
