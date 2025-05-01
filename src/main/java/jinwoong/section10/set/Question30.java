package jinwoong.section10.set;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Question30 {
    /**
     * 간단한 유니온-파인드 알고리즘 구현하기
     * @param k 노드의 개수 (0 <= k <= 1,000)
     * @param operations 수행할 연산 배열
     * @return 연산 결과를 연산 순서대로 담은 배열
     */
    /* 제약조건
     * 0 <= k <= 1,000
     * 1 <= len(operations) <= 100,000
     * operations[i][0]은 정수 0 또는 1 중 하나
     * 0은 union 연산, 1은 equals 연산 (뒤로는 두 개의 정수 x, y)
     * x와 y는 0 이상 k-1 이하의 정수
     * 연산은 항상 유효 */

    // 각 노드의 대표 저장
    private int[] representative;

    private void setRepresentative(int k) {
        representative = new int[k];
        for (int i = 0; i < k; i++) {
            representative[i] = i;
        }
    }

    private int find(int x) {
        if (x == representative[x]) {
            return x;
        }

        return find(representative[x]);
    }

    private void union(int x, int y) {
        representative[find(y)] = find(x);
    }

    boolean[] solution(int k, int[][] operations) {
        setRepresentative(k);
        int len = operations.length;
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            int[] operation = operations[i];
            /* 0이면 union 1이면 equals */
            if (operation[0] == 0) {
                union(operation[1], operation[2]);
            }
            if (operation[0] == 1) {
                results.add(find(operation[1]) == find(operation[2]));
            }
        }

        boolean[] unboxed = new boolean[results.size()];
        for (int i = 0; i < unboxed.length; i++) {
            unboxed[i] = results.get(i);
        }
        return unboxed;
    }


}
