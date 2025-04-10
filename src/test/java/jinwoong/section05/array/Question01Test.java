package jinwoong.section05.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question01Test {
    Question01 question;

    @BeforeEach
    void setUp() {
        question = new Question01();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(new int[]{1, -5, 2, 4, 3}, new int[] {-5, 1, 2, 3, 4}),
                Arguments.arguments(new int[]{2, 1, 1, 3, 2, 5, 4}, new int[] {1, 1, 2, 2, 3, 4, 5}),
                Arguments.arguments(new int[]{6, 1, 7}, new int[] {1, 6, 7})

        );
    }

    @DisplayName("Question01 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int[] arr, int[] expected) {
        int[] result = question.solution(arr);
        Assertions.assertArrayEquals(expected, result);
    }

}