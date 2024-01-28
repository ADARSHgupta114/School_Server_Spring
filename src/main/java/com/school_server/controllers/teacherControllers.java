package com.school_server.controllers;


import com.school_server.entity.Teacher;
import com.school_server.payload.teacherDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teachers/")
public class teacherControllers {
//    @PostMapping("/save-teacher")
//    public ResponseEntity<?> saveTeacher(@Valid @RequestBody teacherDTO dto, BindingResult result){
//        if(result.hasErrors())
//            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        else
//
//    }

}
