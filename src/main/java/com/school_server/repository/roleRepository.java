package com.school_server.repository;

import com.school_server.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface roleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(String name);
}
