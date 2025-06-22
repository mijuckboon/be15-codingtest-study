package jinwoong.section14.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question60Test {
    Question60 question;

    @BeforeEach
    void setUp() {
        question = new Question60();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}
                        },
                        new int[][] {
                                {9, 8, 7},
                                {6, 5, 4},
                                {3, 2, 1}
                        },
                        new int[][] {
                                {30, 84, 138},
                                {24, 69, 114},
                                {18, 54, 90}
                        }
                ),
                Arguments.arguments(
                        new int[][] {
                                {2, 4, 6},
                                {1, 3, 5},
                                {7, 8, 9}
                        },
                        new int[][] {
                                {9, 1, 2},
                                {4, 5, 6},
                                {7, 3, 8}
                        },
                        new int[][] {
                                {76, 56, 158},
                                {40, 31, 74},
                                {76, 60, 134}
                        }
                )
        );
    }

    @DisplayName("Question60 테스트")
    @ParameterizedTest(name = "test {index}: matrix1={0}, matrix2={1}")
    @MethodSource("provideTestCases")
    void testSolution(int[][] matrix1, int[][] matrix2, int[][] expected) {
        int[][] result = question.solution(matrix1, matrix2);
        Assertions.assertArrayEquals(expected, result);
    }

}