package com.example.ss.controller;


import com.example.ss.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> studentList = new ArrayList<>();


    @PreAuthorize("hasRole('user')")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        Student student1 = new Student("100", "Ram", "Civil");
        Student student2 = new Student("200", "Mohan", "CSE");
        return ResponseEntity.ok(List.of(student1, student2));
    }

    @PreAuthorize("hasRole('admin')")
    @PostMapping("/students")
    public ResponseEntity<List<Student>> addStudent(@RequestBody Student student) {
        studentList.add(student);
        return ResponseEntity.ok(studentList);
    }


}
