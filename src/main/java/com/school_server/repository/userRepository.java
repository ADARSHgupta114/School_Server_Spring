package com.school_server.repository;

import com.school_server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);
}
