package com.stackinsat.test.demo.service;

import com.stackinsat.test.demo.configuration.Constantes;
import com.stackinsat.test.demo.entity.Personne;
import com.stackinsat.test.demo.exception.BadRequestException;
import com.stackinsat.test.demo.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class PersonneService {

    PersonneRepository personneRepository;

    public List<Personne> getPersonnes() {
        log.info("getPersonnes - findAll is called");
        List<Personne> personneList = personneRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
        personneList.stream().forEach(
                personne -> personne.setActualAge(calculateAge(personne.getDateOfBirth(), LocalDate.now()))
        );
        return personneList;
    }

    public int calculateAge(LocalDate birthDate,LocalDate currentDate) {
        return Period.between(birthDate, currentDate).getYears();
    }

    public void addPersonne(Personne personne) {
        log.info("addPersonne - if younger than 150 years, then save - personne: "+personne.toString());
        int age = calculateAge(personne.getDateOfBirth(), LocalDate.now());
        log.info("addPersonne - actual age of the person - age: "+age);
        personne.setActualAge(age);
        if(age >= Constantes.MAXIMUM_AGE_ALLOWED) {
            log.warn("addPersonne - The person is too old - age: "+age);
            throw new BadRequestException("addPersonne - A person can not be "+Constantes.MAXIMUM_AGE_ALLOWED+ " years old or more");
        }
        personneRepository.save(personne);
    }
}
