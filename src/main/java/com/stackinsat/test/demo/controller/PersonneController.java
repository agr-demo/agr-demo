package com.stackinsat.test.demo.controller;

import com.stackinsat.test.demo.entity.Personne;
import com.stackinsat.test.demo.service.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personnes")
@AllArgsConstructor
public class PersonneController {

    PersonneService personneService;

    @GetMapping("/all")
    public List<Personne> getCustomers() {
        return personneService.getPersonnes();
    }

}
