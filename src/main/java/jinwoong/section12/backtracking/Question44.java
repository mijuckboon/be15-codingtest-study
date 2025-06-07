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
        int boxRow = (row / 3) * 3;
        int boxCol = (col / 3) * 3;

        return Arrays.stream(board).map(b -> new int[]{b[boxCol * 3], b[boxCol * 3 + 1], b[boxCol * 3 + 2]})
                .anyMatch(x ->
                        x[boxRow * 3] == num || x[boxRow * 3 + 1] == num || x[boxRow * 3 + 2] == num // 중괄호 사용 시 "return" 필요
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


    /**
     * 스도쿠 퍼즐
     *
     * @param board 주어진 스도쿠 보드 (완성할 수 있음)
     * @return 완성된 스도쿠 보드
     */
    public int[][] solution(int[][] board) {
        Cell emptyCell = emptyPosition(board);

        if (emptyCell == null) {
            return board;
        }

        int row = emptyCell.row;
        int col = emptyCell.col;

        for (int num = 1; num <= 9; num++) {
            if (isValid(num, row, col, board)) {
                board[row][col] = num;

                if (emptyPosition(board) != null) {
                    solution(board);
                }

                // 가능한 숫자가 없으면 다시 0으로 되돌림
                board[row][col] = 0;
            }
        }
        return board;
    }
}
