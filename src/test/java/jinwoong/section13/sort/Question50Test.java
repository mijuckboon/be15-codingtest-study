package jinwoong.section13.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question50Test {
    Question50 question;

    @BeforeEach
    void setUp() {
        question = new Question50();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        "hello",
                        "ehllo"
                ),
                Arguments.arguments(
                        "algorithm",
                        "aghilmort"
                )
        );
    }

    @DisplayName("Question50 테스트")
    @ParameterizedTest(name = "test {index}: s={0}")
    @MethodSource("provideTestCases")
    void testSolution(String s, String expected) {
        String result = question.solution(s);
        Assertions.assertEquals(expected, result);
    }

}