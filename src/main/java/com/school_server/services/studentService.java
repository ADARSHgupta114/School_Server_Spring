package com.school_server.services;

import com.school_server.entity.Student;
import com.school_server.payload.studentDTO;

import java.util.List;
import java.util.Optional;

public interface studentService {
    List<studentDTO> getAllstudent(int pageno,int pagesize,String sortby,String sortbydir);
    void saveStudents(Student student);
    Optional<Student> findById(long id);
    void deleteStudent(long id);
    studentDTO updateStudentService(long id, studentDTO dto);
}
