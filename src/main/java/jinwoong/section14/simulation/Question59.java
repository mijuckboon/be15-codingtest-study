package jinwoong.section14.simulation;

import java.util.Arrays;

public class Question59 {
    /**
     * 배열 회전하기
     * <p>
     * 제약조건 <br/>
     * n은 1 이상 4 이하의 자연수 <br/>
     * 2차원 배열의 행과 열의 크기는 같고, 행의 크기는 10을 넘지 않음
     * </p>
     *
     * @param arr 2차원 배열
     * @param n 시계방향 회전 횟수
     * @return 회전 결과
     */
    int[][] solution(int[][] arr, int n) {
        int len = arr.length;

        int[][] prev = new int[len][len];
        for (int row = 0; row < len; row++) {
            for (int col = 0; col < len; col++) {
                prev[row][col] = arr[row][col];
            }
        }

        int[][] result = new int[len][len];

        for (int rep = 0; rep < n; rep++) {
            for (int row = 0; row < len; row++) {
                for (int col = 0; col < len; col++) {
                    result[col][len - 1 - row] = prev[row][col];
                }
            }


            for (int row = 0; row < len; row++) {
                for (int col = 0; col < len; col++) {
                    prev[row][col] = result[row][col];
                }
            }
        }

        return result;
    }
}
