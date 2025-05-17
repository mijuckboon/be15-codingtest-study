package jinwoong.section11.graph;

import jinwoong.section10.set.Question30;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Question36Test {
    Question36 question;

    @BeforeEach
    void setUp() {
        question = new Question36();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {{0, 1, 9}, {0, 2, 3}, {1, 0, 5}, {2, 1, 1}},
                        0,
                        3,
                        new int[] {0, 4, 3}
                ),
                Arguments.arguments(
                        new int[][] {{0, 1, 1}, {1, 2, 5}, {2, 3, 1}},
                        0,
                        4,
                        new int[] {0, 1, 6, 7}
                )
        );
    }

    @DisplayName("Question36 테스트")
    @ParameterizedTest(name="test {index}: graph={0}, start={1}, n={2}")
    @MethodSource("provideTestCases")
    void testSolution(int[][] graph, int start, int n, int[] expected) {
        int[] result = question.solution(graph, start, n);
        Assertions.assertArrayEquals(expected, result);
    }
}