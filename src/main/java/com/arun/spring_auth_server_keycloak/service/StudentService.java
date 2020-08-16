package com.arun.spring_auth_server_keycloak.service;

import com.arun.spring_auth_server_keycloak.model.Student;

/**
 * @author arun on 8/15/20
 */
public interface StudentService {

    Student student(String name);
}
