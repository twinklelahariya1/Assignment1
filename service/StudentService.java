package com.gl.hibernate.service;

import com.gl.hibernate.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> displayStudents();

    void deleteStudent(Long studentId);
}
