package jinwoong.section14.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question61Test {
    Question61 question;

    @BeforeEach
    void setUp() {
        question = new Question61();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        3,
                        new int[][] {
                                {1, 2, 3},
                                {8, 9, 4},
                                {7, 6, 5}
                        }
                ),
                Arguments.arguments(
                        4,
                        new int[][] {
                                {1, 2, 3, 4},
                                {12, 13, 14, 5},
                                {11, 16, 15, 6},
                                {10, 9, 8, 7},

                        }
                )
        );
    }

    @DisplayName("Question61 테스트")
    @ParameterizedTest(name = "test {index}: n={0}")
    @MethodSource("provideTestCases")
    void testSolution(int n, int[][] expected) {
        int[][] result = question.solution(n);
        Assertions.assertArrayEquals(expected, result);
    }

}