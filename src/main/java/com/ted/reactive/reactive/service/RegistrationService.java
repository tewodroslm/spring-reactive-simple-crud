package com.ted.reactive.reactive.service;

import com.ted.reactive.reactive.entity.Student;
import com.ted.reactive.reactive.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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

}

