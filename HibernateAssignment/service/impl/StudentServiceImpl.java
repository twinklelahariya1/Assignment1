package com.gl.hibernate.service.impl;


import com.gl.hibernate.model.Student;
import com.gl.hibernate.repository.StudentRepository;
import com.gl.hibernate.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public Student addStudent(Student student) {
        student = studentRepository.save(student);
        return student;
    }

    @Override
    public List<Student> displayStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
