package stream;

import de.cloudypanda.stream.IntegerStreamService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerStreamServiceTest {

    public static Stream<Arguments> filterEvenStreamValues() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5), List.of(1,3,5)),
                Arguments.of(List.of(0,1,2,3,4), List.of(1,3)),
                Arguments.of(List.of(2,4,600), List.of()),
                Arguments.of(List.of(), List.of())
        );
    }

    public static Stream<Arguments> filterOddStreamValues() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5), List.of(2,4)),
                Arguments.of(List.of(0,1,2,3,4), List.of(0,2,4)),
                Arguments.of(List.of(2,4,600), List.of(2,4,600)),
                Arguments.of(List.of(3,5,7), List.of()),
                Arguments.of(List.of(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("filterOddStreamValues")
    void filterOddStream(List<Integer> elements, List<Integer> result) {
        var service = new IntegerStreamService(elements);

        var actual = service.filterOddElements();

        assertThat(actual).size().isEqualTo(result.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("filterEvenStreamValues")
    void filterEvenStream(List<Integer> elements, List<Integer> result) {
        var service = new IntegerStreamService(elements);

        var actual = service.filterEvenElements();

        assertThat(actual).size().isEqualTo(result.size());
        assertThat(actual).containsExactlyElementsOf(result);
    }


}
