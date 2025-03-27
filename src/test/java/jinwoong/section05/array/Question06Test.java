package jinwoong.section05.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question06Test {
    Question06 question;

    @BeforeEach
    void setUp() {
        question = new Question06();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3}, new int[] {3, 4, 2, 1, 5}),
                Arguments.arguments(4, new int[] {4, 4, 4, 4, 4}, new int[] {4, 1, 2, 3})
        );
    }

    @DisplayName("Question06 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int N, int[] stages, int[] expected) {
        int[] result = question.solution(N, stages);
        Assertions.assertArrayEquals(expected, result);
    }

}