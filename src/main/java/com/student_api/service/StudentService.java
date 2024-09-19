package com.student_api.service;

import com.student_api.entity.Student;

import java.util.List;

public interface StudentService {
    void save(Student student);
    List<Student> findAll();
    Student findStudentById(int id);
    void update(Student student);
    void delete(int id);
}
