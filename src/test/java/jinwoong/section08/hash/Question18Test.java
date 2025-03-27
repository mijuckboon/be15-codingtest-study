package jinwoong.section08.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question18Test {

    Question18 question;

    @BeforeEach
    void setUp() {
        question = new Question18();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(new int[] {1, 2, 3, 4, 8}, 6, true),
                Arguments.arguments(new int[] {2, 3, 5, 9}, 10, false)
        );
    }

    @DisplayName("Question18 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int[] arr, int target, boolean expected) {
        boolean result = question.solution(arr, target);
        Assertions.assertEquals(expected, result);
    }

}