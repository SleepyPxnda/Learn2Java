package de.cloudypanda.stream.models;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public record PersonDTO(String name, LocalDate dateOfBirth) {
}
