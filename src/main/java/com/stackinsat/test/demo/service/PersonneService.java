package com.stackinsat.test.demo.service;

import com.stackinsat.test.demo.entity.Personne;
import com.stackinsat.test.demo.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PersonneService {

    PersonneRepository personneRepository;


    public List<Personne> getPersonnes() {
        log.info("getPersonnes - findAll is called");
        return personneRepository.findAll();
    }
}
