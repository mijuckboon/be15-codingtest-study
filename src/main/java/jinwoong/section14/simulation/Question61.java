package jinwoong.section14.simulation;

public class Question61 {
    /**
     * 달팽이 수열 만들기
     * <p>
     * 제약조건 <br/>
     * n은 2 이상 10 미만의 자연수 <br/>
     * 숫자는 배열의 첫 번째 행, 첫 번째 열에서 시작
     * </p>
     *
     * @param n 자연수
     * @return 달팽이 수열을 나타내는 행렬
     */
    int[][] solution(int n) {
        int[][] snail = new int[n][n];
        int seq = 1;

        int minRow = 0;
        int maxRow = n - 1;
        int minCol = 0;
        int maxCol = n - 1;

        while (minRow <= maxRow && minCol <= maxCol) {
            for (int col = minCol; col <= maxCol; col++) {
                snail[minRow][col] = seq;
                seq += 1;
            }
            minRow += 1;

            for (int row = minRow; row <= maxRow; row++) {
                snail[row][maxCol] = seq;
                seq += 1;
            }
            maxCol -= 1;

            for (int col = maxCol; col >= minCol; col--) {
                snail[maxRow][col] = seq;
                seq += 1;
            }
            maxRow -= 1;

            for (int row = maxRow; row >= minRow; row--) {
                snail[row][minCol] = seq;
                seq += 1;
            }
            minCol += 1;
        }

        return snail;
    }

    public int[][] solution2(int n) { // 그래프 탐색 ver (gpt)
        int[][] snail = new int[n][n];
        boolean[][] visited = new boolean[n][n];

        // 우, 하, 좌, 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int row = 0, col = 0, dir = 0;

        for (int i = 1; i <= n * n; i++) {
            snail[row][col] = i;
            visited[row][col] = true;

            int nextRow = row + dr[dir];
            int nextCol = col + dc[dir];

            if (!isValid(nextRow, nextCol, n, visited)) {
                dir = (dir + 1) % 4;
                nextRow = row + dr[dir];
                nextCol = col + dc[dir];
            }

            row = nextRow;
            col = nextCol;
        }

        return snail;
    }

    private boolean isValid(int row, int col, int size, boolean[][] visited) {
        return row >= 0 && row < size && col >= 0 && col < size && !visited[row][col];
    }
}
