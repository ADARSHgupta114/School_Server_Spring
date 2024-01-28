package com.school_server.services.impl;

import com.school_server.entity.Student;
import com.school_server.payload.studentDTO;
import com.school_server.repository.studentRepository;
import com.school_server.services.studentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class studentServImpl implements studentService {
    private studentRepository studentrepo;

    public studentServImpl(studentRepository studentrepo) {
        this.studentrepo = studentrepo;
    }

    @Override
    public List<studentDTO> getAllstudent(int pageno,int pagesize,String sortby,String sortbydir) {
        Sort sort = (sortbydir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortby).ascending():Sort.by(sortby).descending();
        Pageable pagable = PageRequest.of(pageno, pagesize, sort);

        Page<Student> pagestudent = studentrepo.findAll(pagable);
        List<Student> student = pagestudent.getContent();
        List<studentDTO> dto = student.stream().map(students->maptoDTO(students)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public void saveStudents(Student student) {
        studentrepo.save(student);
    }

    @Override
    public Optional<Student> findById(long id) {
        return studentrepo.findById(id);
    }

    @Override
    public void deleteStudent(long id) {
        studentrepo.deleteById(id);
    }
    studentDTO maptoDTO(Student student){
        studentDTO dto = new studentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setFather(student.getFather());
        dto.setMother(student.getMother());
        dto.setDOB(student.getDOB());
        dto.setMobile(student.getMobile());
        dto.setGender(student.getGender());
        dto.setEmail(student.getEmail());
        dto.setStandard(student.getStandard());
        dto.setDOA(student.getDOA());
        dto.setAddress(student.getAddress());
        return dto;
    }

}
