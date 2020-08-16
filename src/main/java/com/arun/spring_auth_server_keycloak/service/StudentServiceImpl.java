package com.arun.spring_auth_server_keycloak.service;

import com.arun.spring_auth_server_keycloak.model.Student;
import com.arun.spring_auth_server_keycloak.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author arun on 8/15/20
 */

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student student(String name) {
        return studentRepository.findByName(name);
    }
}
