package com.example.studentapi.repository;

import com.example.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    boolean existsByEmailAddressIgnoreCase(String emailAddress);
    List<Student> findByCourseNameIgnoreCase(String courseName);
    List<Student> findByEmailAddressIgnoreCase(String emailAddress);
}
