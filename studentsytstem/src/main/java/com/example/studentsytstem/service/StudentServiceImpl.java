package com.example.studentsytstem.service;

import com.example.studentsytstem.entity.Student;
import com.example.studentsytstem.exception.GlobalExceptions;
import com.example.studentsytstem.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{


    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()){
            return studentOptional.get();
        }
        throw new GlobalExceptions("Student is not exist", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Student delete(Long id) {
        Student student = findById(id);
        if (student != null){
             studentRepository.delete(student);
        }
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }
}
