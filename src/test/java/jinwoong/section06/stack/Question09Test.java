package jinwoong.section06.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question09Test {
    Question09 question;

    @BeforeEach
    void setUp() {
        question = new Question09();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(10, "1010"),
                Arguments.arguments(27, "11011"),
                Arguments.arguments(12345, "11000000111001")
        );
    }

    @DisplayName("Question09 테스트")
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution(int num, String expected) {
        String result = question.solution(num);
        Assertions.assertEquals(expected, result);
    }

}