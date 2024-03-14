package com.example.studentsytstem.repository;

import com.example.studentsytstem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
