package com.arun.spring_auth_server_keycloak.config;

import com.arun.spring_auth_server_keycloak.model.Student;
import com.arun.spring_auth_server_keycloak.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author arun on 8/15/20
 */

@Configuration
public class StudentLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentLoader(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        load();
    }

    public void load() {

        for (int i = 0; i < 10; i++) {
            Student student = Student.builder()
                    .age((i + 1) * 2)
                    .name(i + "abc")
                    .standard("2")
                    .department("science")
                    .build();

            studentRepository.save(student);
        }
    }
}
