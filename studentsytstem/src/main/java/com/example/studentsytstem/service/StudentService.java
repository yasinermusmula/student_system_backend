package com.example.studentsytstem.service;

import com.example.studentsytstem.entity.Student;

import java.util.List;

public interface StudentService {
    Student save (Student student);

    Student findById(Long id);

    Student delete(Long id);

    List<Student> findAllStudent();
}
