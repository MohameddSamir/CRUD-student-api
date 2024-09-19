package com.student_api.rest;

import com.student_api.entity.Student;
import com.student_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentRestController {
    private final StudentService service;
    @Autowired
    public StudentRestController(StudentService service){
        this.service=service;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return service.findAll();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId){
        return service.findStudentById(studentId);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
        service.save(student);
    }

    @PutMapping
    public void updateStudent(@RequestBody Student student){
        service.update(student);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudentById(@PathVariable int studentId){
        service.delete(studentId);
    }
}
