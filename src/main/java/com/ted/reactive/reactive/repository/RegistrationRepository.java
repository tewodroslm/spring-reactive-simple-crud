package com.ted.reactive.reactive.repository;

import com.ted.reactive.reactive.entity.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends ReactiveMongoRepository<Student, String> {
}
