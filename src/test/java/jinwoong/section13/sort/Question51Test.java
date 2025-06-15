package jinwoong.section13.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Question51Test {
    Question51 question;

    @BeforeEach
    void setUp() {
        question = new Question51();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[] {1, 3, 5},
                        new int[] {2, 4 ,6},
                        new int[] {1, 2, 3, 4, 5 ,6}
                ),
                Arguments.arguments(
                        new int[] {1, 2, 3},
                        new int[] {4, 5, 6},
                        new int[] {1, 2, 3, 4, 5 ,6}
                )
        );
    }

    @DisplayName("Question51 테스트")
    @ParameterizedTest(name = "test {index}: arr1={0}, arr2={1}")
    @MethodSource("provideTestCases")
    void testSolution(int[] arr1, int[] arr2, int[] expected) {
        int[] result = question.solution(arr1, arr2);
        Assertions.assertArrayEquals(expected, result);
    }

}