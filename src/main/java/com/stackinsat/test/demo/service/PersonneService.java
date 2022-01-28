package com.stackinsat.test.demo.service;

import com.stackinsat.test.demo.entity.Personne;
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
}
