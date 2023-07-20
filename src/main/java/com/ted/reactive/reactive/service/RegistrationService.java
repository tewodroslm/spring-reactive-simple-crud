package com.ted.reactive.reactive.service;

import com.ted.reactive.reactive.entity.Student;
import com.ted.reactive.reactive.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public Flux<Student> getAll(){
        return registrationRepository.findAll().switchIfEmpty(Flux.empty());
    }

    public Mono save(final Student student){
        return registrationRepository.save(student);
    }

    public Mono<Student> getById(String id){
        return registrationRepository.findById(id);
    }

    public Mono update(final String id, Student student){
        Mono<Student> studentMono = registrationRepository.findById(id);
        Mono<Student> updateStudent = studentMono.map(student1 -> {
            student1.setFirstName(student.getFirstName());
            student1.setLastName(student.getLastName());
            return student1;
        });
        Mono<Student> saveStudent = updateStudent.flatMap(registrationRepository::save);
        saveStudent.subscribe();
        return saveStudent;
    }

    public Mono delete(final String id){
        return registrationRepository.deleteById(id);
    }

}

