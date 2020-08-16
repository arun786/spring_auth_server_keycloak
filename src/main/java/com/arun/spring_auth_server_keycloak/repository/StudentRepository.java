package com.arun.spring_auth_server_keycloak.repository;

import com.arun.spring_auth_server_keycloak.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author arun on 8/15/20
 */
public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    Student findByName(String name);
}
