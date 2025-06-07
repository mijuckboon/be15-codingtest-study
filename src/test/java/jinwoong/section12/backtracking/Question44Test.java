package jinwoong.section12.backtracking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Question44Test {
    Question44 question;

    @BeforeEach
    void setUp() {
        question = new Question44();
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.arguments(
                        new int[][] {
                                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                                {0, 0, 0, 0, 8, 0, 0, 7, 9}
                        },
                        new int[][] {
                                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                                {3, 4, 5, 2, 8, 6, 1, 7, 9}
                        }
                ),
                Arguments.arguments(
                        new int[][] {
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0}
                        },
//                        new int[][] {
//                                {1, 2, 3, 4, 5, 6, 7, 8, 9},
//                                {4, 5, 6, 7, 8, 9, 1, 2, 3},
//                                {7, 8, 9, 1, 2, 3, 4, 5, 6},
//                                {2, 3, 4, 5, 6, 7, 8, 9, 1},
//                                {5, 6, 7, 8, 9, 1, 2, 3, 4},
//                                {8, 9, 1, 2, 3, 4, 5, 6, 7},
//                                {3, 4, 5, 6, 7, 8, 9, 1, 2},
//                                {6, 7, 8, 9, 1, 2, 3, 4, 5},
//                                {9, 1, 2, 3, 4, 5, 6, 7, 8},
//                        }
                        new int[][] {
                                {1, 2, 3, 4, 5, 6, 7, 8, 9},
                                {4, 5, 6, 7, 8, 9, 1, 2, 3},
                                {7, 8, 9, 1, 2, 3, 4, 5, 6},
                                {2, 1, 4, 3, 6, 5, 8, 9, 7},
                                {3, 6, 5, 8, 9, 7, 2, 1, 4},
                                {8, 9, 7, 2, 1, 4, 3, 6, 5},
                                {5, 3, 1, 6, 4, 2, 9, 7, 8},
                                {6, 4, 2, 9, 7, 8, 5, 3, 1},
                                {9, 7, 8, 5, 3, 1, 6, 4, 2},
                        }
                )
        );
    }

    @DisplayName("Question44 테스트")
    @ParameterizedTest(name = "test {index}: board={0}")
    @MethodSource("provideTestCases")
    void testSolution(int[][] board, int[][] expected) {
        int[][] result = question.solution(board);
        Assertions.assertTrue(isValidSudoku(result));
//        Assertions.assertArrayEquals(expected, result);
    }

    // 테스트용 유틸 함수
    private boolean isValidSudoku(int[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            boolean[] boxCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int rowVal = board[i][j];
                int colVal = board[j][i];
                int boxVal = board[(i / 3) * 3 + j / 3][(i % 3) * 3 + j % 3];

                if (rowCheck[rowVal] || colCheck[colVal] || boxCheck[boxVal]) return false;
                rowCheck[rowVal] = colCheck[colVal] = boxCheck[boxVal] = true;
            }
        }
        return true;
    }
}