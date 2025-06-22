package jinwoong.section14.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question59Test {
    Question59 question;

    @BeforeEach
    void setUp() {
        question = new Question59();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        1,
                        new int[][] {
                                {13, 9, 5, 1},
                                {14, 10, 6, 2},
                                {15, 11, 7, 3},
                                {16, 12, 8, 4},
                        }
                ),
                Arguments.arguments(
                        new int[][] {
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16}
                        },
                        2,
                        new int[][] {
                                {16, 15, 14, 13},
                                {12, 11, 10, 9},
                                {8, 7, 6, 5},
                                {4, 3, 2, 1},
                        }
                )
        );
    }

    @DisplayName("Question59 테스트")
    @ParameterizedTest(name = "test {index}: arr={0}, n={1}")
    @MethodSource("provideTestCases")
    void testSolution(int[][] arr, int n, int[][] expected) {
        int[][] result = question.solution(arr, n);
        Assertions.assertArrayEquals(expected, result);
    }

}