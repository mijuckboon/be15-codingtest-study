package jinwoong.section12.backtracking;

import java.util.Arrays;

public class Question44 {


    public class Cell {
        int row;
        int col;

        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static boolean isValid(int num, int row, int col, int[][] board) {
        return !isInRow(num, row, board) && !isInColumn(num, col, board) && !isInBox(num, row, col, board);
    }

    private static boolean isInRow(int num, int row, int[][] board) {
        return Arrays.stream(board[row])
                .anyMatch(x -> x == num);
    }

    private static boolean isInColumn(int num, int col, int[][] board) {
        return Arrays.stream(board)
                .map(b -> b[col])
                .anyMatch(x -> x == num);
    }

    private static boolean isInBox(int num, int row, int col, int[][] board) {
        int boxRow = row / 3;
        int boxCol = col / 3;

        return Arrays.stream(new int[][]{
                                board[boxRow * 3],
                                board[boxRow * 3 + 1],
                                board[boxRow * 3 + 2]
                        }
                )
                .anyMatch(x ->
                              x[boxCol * 3] == num
                           || x[boxCol * 3 + 1] == num
                           || x[boxCol * 3 + 2] == num
                );
    }

    private Cell emptyPosition(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }

    private boolean solve(int[][] board) {
        Cell emptyCell = emptyPosition(board);

        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell.row;
        int col = emptyCell.col;

        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col, board)) {
                board[row][col] = num;

                if (solve(board)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }
        return false;
    }


    /**
     * 스도쿠 퍼즐
     *
     * @param board 주어진 스도쿠 보드 (완성할 수 있음)
     * @return 완성된 스도쿠 보드
     */
    public int[][] solution(int[][] board) {
        solve(board);
        return board;
    }
}
