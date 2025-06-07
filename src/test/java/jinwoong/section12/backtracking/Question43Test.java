package jinwoong.section12.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class Question43Test {
    Question43 question;

    @BeforeEach
    void setUp() {
        question = new Question43();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        5,
                        List.of(
                                new int[]{1, 2, 3, 4},
                                new int[]{1, 4, 5},
                                new int[]{2, 3, 5}
                        )
                ),
                Arguments.arguments(
                        2,
                        List.of(
                                new int[]{}
                        )
                ),
                Arguments.arguments(
                        7,
                        List.of(
                                new int[]{1, 2, 3, 4},
                                new int[]{1, 2, 7},
                                new int[]{1, 3, 6},
                                new int[]{1, 4, 5},
                                new int[]{2, 3, 5},
                                new int[]{3, 7},
                                new int[]{4, 6}
                        )
                )
        );
    }

    @DisplayName("Question43 테스트")
    @ParameterizedTest(name = "test {index}: n={0}")
    @MethodSource("provideTestCases")
    void testSolution(int n, List<List<Integer>> expected) {
        List<List<Integer>> result = question.solution(n);
        Assertions.assertEquals(expected, result);
    }
}