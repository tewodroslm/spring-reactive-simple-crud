package com.ted.reactive.reactive.controller;

import com.ted.reactive.reactive.entity.Student;
import com.ted.reactive.reactive.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("student")
@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping
    public Mono save(@RequestBody final Student student){
        return registrationService.save(student);
    }

    @GetMapping
    public Flux<Student> getAll(){
        return registrationService.getAll();
    }

}