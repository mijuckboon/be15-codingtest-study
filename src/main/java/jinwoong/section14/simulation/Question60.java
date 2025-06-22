package jinwoong.section14.simulation;

public class Question60 {
    /**
     * 두 행렬을 곱한 후 전치 행렬 만들기
     * <p>
     * 제약조건 <br/>
     * matrix1, matrix2는 각각 3 x 3 크기의 정수 행렬
     * </p>
     *
     * @param matrix1 행렬
     * @param matrix2 행렬
     * @return 곱한 결과의 전치 행렬
     */
    int[][] solution(int[][] matrix1, int[][] matrix2) {
        int[][] product = product(matrix1, matrix2);
        int[][] transpose = transpose(product);

        return transpose;
    }

    int[][] product(int[][] matrix1, int[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
//        int row2 = matrix2.length; (col1 == row2)
        int col2 = matrix2[0].length;

        int[][] result = new int[row1][col2];

        for (int row = 0; row < row1; row++) {
            for (int col = 0; col < col2; col++) {
                for (int k = 0; k < col1; k++) {
                    result[row][col] += matrix1[row][k] * matrix2[k][col];
                }

            }
        }

        return result;
    }

    int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[col][row];

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
