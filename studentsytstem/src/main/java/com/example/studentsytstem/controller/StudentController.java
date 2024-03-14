package com.example.studentsytstem.controller;

import com.example.studentsytstem.entity.Student;
import com.example.studentsytstem.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    public Student save(@RequestBody Student student){
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

    @GetMapping("/")
    public List<Student> findAllStudent(){
        return studentService.findAllStudent();
    }

    @DeleteMapping("/{id}")
    public Student delete(@PathVariable Long id){
        return studentService.delete(id);
    }
}
