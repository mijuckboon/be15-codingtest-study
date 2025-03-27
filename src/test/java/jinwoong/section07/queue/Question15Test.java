package jinwoong.section07.queue;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

class Question15Test {
    Question15 question;

    @BeforeEach
    void setUp() {
        question = new Question15();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(5, 2, 3)
        );
    }

    @DisplayName("Question15 테스트")
    @ParameterizedTest
    @CsvSource("5, 2, 3")
    void testSolution(int n, int k, int expected) {
        int result = question.solution(n, k);
        Assertions.assertEquals(expected, result);
    }
    /* 여러 줄 사용법
     * @CsvSource({
           "5, 2, 3",
           "10, 3, 7",
           "15, 5, 10"
       }) */

    @Disabled
    @Test
    void testSolution() {
        int n = 5;
        int k = 2;
        int expected = 3;

        int result = question.solution(n, k);
        Assertions.assertEquals(expected, result);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("provideTestCases")
    void testSolution2(int n, int k, int expected) {
        int result = question.solution(n, k);
        Assertions.assertEquals(expected, result);
    }
}