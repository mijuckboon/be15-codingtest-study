package jinwoong.section06.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question08Test {
    Question08 question;

    @BeforeEach
    void setUp() {
        question = new Question08();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments("()()", true),
                Arguments.arguments("(())()", true),
                Arguments.arguments(")()(", false),
                Arguments.arguments("(()(", false)
        );
    }


    @DisplayName("Question08 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(String s, boolean expected) {
        boolean result = question.solution(s);
        Assertions.assertEquals(expected, result);
    }

}