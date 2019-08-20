package com.gl.hibernate.controller;


import com.gl.hibernate.model.Student;
import com.gl.hibernate.service.impl.StudentServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentServiceImpl studentServiceimpl;

    public StudentController(StudentServiceImpl studentServiceimpl) {
        this.studentServiceimpl = studentServiceimpl;
    }


    @GetMapping("/showStudent")
    public ResponseEntity<List> displayStudent() {
        return ResponseEntity.ok(studentServiceimpl.displayStudents());
    }


    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student updated = studentServiceimpl.addStudent(student);
        return new ResponseEntity<>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public HttpStatus deleteStudent(@PathVariable("studentId") Long studentId) {
        studentServiceimpl.deleteStudent(studentId);
        return HttpStatus.FORBIDDEN;
    }
}
