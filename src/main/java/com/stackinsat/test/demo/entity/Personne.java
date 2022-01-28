package com.stackinsat.test.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table(name="PERSONNE")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
public class Personne {

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    @JsonProperty("person_id")
    private Long id;

    @NotBlank(message = "firstName must not be empty")
    @JsonProperty("firstName")
    private String firstName;

    @NotBlank(message = "lastName must not be empty")
    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("dateOfBirth")
    private LocalDate dateOfBirth;

    @Transient
    @JsonProperty("actualAge")
    private int actualAge;
}
