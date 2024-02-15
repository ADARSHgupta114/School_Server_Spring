package com.school_server.controllers;

import com.school_server.entity.Student;
import com.school_server.exception.ResourceNotFoundException;
import com.school_server.payload.readStudentDTO;
import com.school_server.payload.studentDTO;
import com.school_server.repository.studentRepository;
import com.school_server.services.studentService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/students")
public class studentController {
   private studentService studentservice;

    public studentController(studentService studentservice) {
        this.studentservice = studentservice;
    }
    //http://localhost:8080/api/students/save-student

    @PostMapping("/save-student")
    public ResponseEntity<?> saveStudent(@Valid @RequestBody Student student, BindingResult result){
        if(result.hasErrors())
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        studentservice.saveStudents(student);
        return new ResponseEntity<>(student,HttpStatus.CREATED);
    }
    //http://localhost:8080/api/students/
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getAstudentById(@PathVariable long id){
        Optional<Student> findById = studentservice.findById(id);
        if(findById.isPresent()){
            return new ResponseEntity<>(studentservice.findById(id).get(),HttpStatus.OK);
        }
        else
            throw new ResourceNotFoundException("Student Not Found with id"+id);
    }
    //http://localhost:8080/api/students/all?pageno=0&pagesize=&sortby=desc
    @GetMapping("/all")
    public ResponseEntity<?> getAllsudetents(
            @RequestParam(name="pageno",required = false,defaultValue = "0") int pageno,
            @RequestParam(name="pagesieze",required = false,defaultValue = "3") int pagesize,
            @RequestParam(name="sortby",required = false,defaultValue = "id") String sortby,
            @RequestParam(name="sortbydir",required = false,defaultValue = "id") String sortbydir
    ){
        List<studentDTO> studentdto = studentservice.getAllstudent(pageno,pagesize,sortby,sortbydir);
        return  new ResponseEntity<>(studentdto,HttpStatus.OK);
    }
    //http://localhost:8080/api/students/delete-student/
    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudentbyId(@PathVariable long id){
        Optional<Student> findById = studentservice.findById(id);
        if(findById.isPresent())
            studentservice.deleteStudent(id);
        else {
            throw new ResourceNotFoundException("Student Not Found with id"+id);
        }
        return new ResponseEntity<>("Record Deleted Successfully",HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update-student/{id}")
    public ResponseEntity<studentDTO> updateStudentById(@PathVariable long id,@RequestBody studentDTO dto){
        studentDTO UpdatedDTO = studentservice.updateStudentService(id,dto);
        return new ResponseEntity<>(UpdatedDTO,HttpStatus.OK);
    }
}
