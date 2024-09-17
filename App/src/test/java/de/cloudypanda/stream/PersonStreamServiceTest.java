package de.cloudypanda.stream;

import de.cloudypanda.stream.models.PersonDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PersonStreamServiceTest {

    public static Stream<Arguments> filterByNameStartingValues() {
        return Stream.of(Arguments.of(
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17)),
                        new PersonDTO("Bob", LocalDate.of(1999, 8, 4)),
                        new PersonDTO("Charlie", LocalDate.of(1998, 3, 5))),
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17))
                )));
    }

    public static Stream<Arguments> filterByAgeValues() {
        return Stream.of(Arguments.of(
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17)),
                        new PersonDTO("Bob", LocalDate.of(1999, 8, 4)),
                        new PersonDTO("Charlie", LocalDate.of(2002, 3, 5))),
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17)),
                        new PersonDTO("Bob", LocalDate.of(1999, 8, 4))
                )));
    }

    public static Stream<Arguments> mapNameToUppercaseValues() {
        return Stream.of(Arguments.of(
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17)),
                        new PersonDTO("Bob", LocalDate.of(1999, 8, 4)),
                        new PersonDTO("Charlie", LocalDate.of(2002, 3, 5))),
                List.of("ALICE", "BOB", "CHARLIE")
        ));
    }

    public static Stream<Arguments> mapComplexToSingleStringValues() {
        return Stream.of(Arguments.of(
                List.of(new PersonDTO("Alice", LocalDate.of(2000, 9, 17)),
                        new PersonDTO("Bob", LocalDate.of(1999, 8, 4)),
                        new PersonDTO("Charlie", LocalDate.of(2002, 3, 5))),
                List.of("Alice - 2000-09-17", "Bob - 1999-08-04", "Charlie - 2002-03-05")
        ));
    }


    @ParameterizedTest
    @MethodSource("filterByNameStartingValues")
    void filterByNameStarting(List<PersonDTO> elements, List<PersonDTO> result) {
        var service = new PersonStreamService(elements);

        var actual = service.filterByNameStarting();

        assertThat(actual).size().isEqualTo(result.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("filterByAgeValues")
    void filterByAge(List<PersonDTO> elements, List<PersonDTO> result) {
        var service = new PersonStreamService(elements);

        var actual = service.filterByDateOfBirth();

        assertThat(actual).size().isEqualTo(result.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("mapNameToUppercaseValues")
    void mapNameToUppercase(List<PersonDTO> elements, List<String> result) {
        var service = new PersonStreamService(elements);

        var actual = service.mapNameToUppercase();

        assertThat(actual).size().isEqualTo(result.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("mapComplexToSingleStringValues")
    void mapComplexToSingleString(List<PersonDTO> elements, List<String> result) {
        var service = new PersonStreamService(elements);

        var actual = service.mapComplexToSingleString();

        assertThat(actual).size().isEqualTo(elements.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }
}