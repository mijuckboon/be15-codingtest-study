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
}
