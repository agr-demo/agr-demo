package com.stackinsat.test.demo.service;

import com.stackinsat.test.demo.repository.PersonneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class) //Replace MockitoAnnotations.openMocks with AutoCloseable
class PersonneServiceTest {

    @Mock
    private PersonneRepository personneRepository;
    private PersonneService personneService;

    @BeforeEach
    void setUp() {
        personneService = new PersonneService(personneRepository);
    }

    @Test
    @Disabled
    void getPersonnes() {
        //FIXME Not yet working, no time to finish - disabled

        // When
        personneService.getPersonnes();
        // Then
        verify(personneRepository).findAll();
    }

    @Test
    @Disabled
    void calculateAge() {
    }

    @Test
    @Disabled
    void addPersonne() {
    }
}