package com.student_api.service;

import com.student_api.dao.StudentDAO;
import com.student_api.entity.Student;
import com.student_api.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentDAO studentDAO;
    @Autowired
    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO=studentDAO;
    }
    @Transactional
    @Override
    public void save(Student student) {
        studentDAO.save(student);
    }
    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }
    @Override
    public Student findStudentById(int id) {
        Student student= studentDAO.findStudentById(id);
        if(student == null){
            throw new StudentNotFoundException("Student with id "+id+" not found");
        }
        return student;
    }
    @Transactional
    @Override
    public void update(Student student) {
        studentDAO.update(student);
    }
    @Transactional
    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }
}
