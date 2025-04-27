package jinwoong.section09.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question25Test {
    Question25 question;

    @BeforeEach
    void setUp() {
        question = new Question25();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[] {1, 2, 3, 4, 5, 6, 7},
                        new String[] {"1 2 4 5 3 6 7", "4 2 5 1 6 3 7", "4 5 2 6 7 3 1"}
                )
        );
    }

    @DisplayName("Question25 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int[] nodes, String[] expected) {
        String[] result = question.solution(nodes);
        Assertions.assertArrayEquals(expected, result);
    }

}