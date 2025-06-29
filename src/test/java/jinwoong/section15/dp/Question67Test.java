package jinwoong.section15.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question67Test {
    Question67 question;

    @BeforeEach
    void setUp() {
        question = new Question67();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        "ABCBDAB",
                        "BDCAB",
                        4
                ),
                Arguments.arguments(
                        "AGGTAB",
                        "GXTXAYB",
                        4
                )
        );
    }

    @DisplayName("Question59 테스트")
    @ParameterizedTest(name = "test {index}: str1={0}, str2={1}")
    @MethodSource("provideTestCases")
    void testSolution(String str1, String str2, int expected) {
        int result = question.solution(str1, str2);
        Assertions.assertEquals(expected, result);
    }

}