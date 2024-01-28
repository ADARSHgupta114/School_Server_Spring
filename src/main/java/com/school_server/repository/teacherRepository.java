package com.school_server.repository;

import com.school_server.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface teacherRepository extends JpaRepository<Teacher,Long> {
}
