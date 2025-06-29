package jinwoong.section15.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question68Test {
    Question68 question;

    @BeforeEach
    void setUp() {
        question = new Question68();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[] {1, 4, 2, 3, 1, 5, 7, 3},
                        5
                ),
                Arguments.arguments(
                        new int[] {3, 2, 1},
                        1
                )
        );
    }

    @DisplayName("Question68 테스트")
    @ParameterizedTest(name = "test {index}: nums={0}")
    @MethodSource("provideTestCases")
    void testSolution(int[] nums, int expected) {
        int result = question.solution(nums);
        Assertions.assertEquals(expected, result);
    }

}