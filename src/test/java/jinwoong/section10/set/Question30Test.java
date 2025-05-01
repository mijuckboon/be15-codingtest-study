package jinwoong.section10.set;

import jinwoong.section09.tree.Question25;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Question30Test {
    Question30 question;

    @BeforeEach
    void setUp() {
        question = new Question30();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        3,
                        new int[][] {{0, 0, 1}, {0, 1, 2}, {1, 1, 2}},
                        new boolean[] {true}
                ),
                Arguments.arguments(
                        4,
                        new int[][] {{0, 0, 1}, {1, 1, 2}, {0, 1, 2}, {1, 0 ,2}},
                        new boolean[] {false, true}
                )
        );
    }

    @DisplayName("Question25 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int k, int[][] operations, boolean[] expected) {
        boolean[] result = question.solution(k, operations);
        Assertions.assertArrayEquals(expected, result);
    }

}