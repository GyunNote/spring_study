package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.Integer.parseInt;

@RestController
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/ex/students")
    public ResponseEntity<?> students() throws JsonProcessingException {
       String json = studentService.getStudentList();
       return ResponseEntity.ok(json);
    }

    @GetMapping("/ex/student/{studentId}")
    public ResponseEntity<?> studentById(@PathVariable int studentId) {
        Object studentInfo = studentService.getStudent(studentId);
        return ResponseEntity.ok(studentInfo);
    }
}

