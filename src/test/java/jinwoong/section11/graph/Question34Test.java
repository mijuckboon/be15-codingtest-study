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

class Question34Test {
    Question34 question;

    @BeforeEach
    void setUp() {
        question = new Question34();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                        1,
                        5,
                        new int[] {1, 2, 3, 4, 5}
                ),
                Arguments.arguments(
                        new int[][] {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {5, 6}},
                        1,
                        6,
                        new int[] {1, 2, 4, 5, 6, 3}
                )
        );
    }

    @DisplayName("Question34 테스트")
    @ParameterizedTest(name="test {index}: k={0}, operations={1}")
    @MethodSource("provideTestCases")
    void testSolution(int[][] graph, int start, int n, int[] expected) {
        int[] result = question.solution(graph, start, n);
        Assertions.assertArrayEquals(expected, result);
    }
}