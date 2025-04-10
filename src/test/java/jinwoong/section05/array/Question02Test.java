package jinwoong.section05.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question02Test {
    Question02 question;

    @BeforeEach
    void setUp() {
        question = new Question02();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(new int[] {4, 2, 2, 1, 3, 4}, new int[]{4, 3, 2, 1}),
                Arguments.arguments(new int[] {2, 1, 1, 3, 2, 5, 4}, new int[]{5, 4, 3, 2, 1})
        );
    }

    @DisplayName("Question02 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int[] arr, int[] expected) {
        int[] result = question.solution(arr);
        Assertions.assertArrayEquals(expected, result);
    }

}