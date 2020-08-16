package com.arun.spring_auth_server_keycloak.controller;

import com.arun.spring_auth_server_keycloak.model.Student;
import com.arun.spring_auth_server_keycloak.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author arun on 8/15/20
 */

@RestController
public class ProfileController {

    private final StudentService studentService;

    @Autowired
    public ProfileController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/v1/student/{name}")
    public ResponseEntity<Student> student(@PathVariable String name) {
        Student student = studentService.student(name);
        return ResponseEntity.ok(student);
    }


}
