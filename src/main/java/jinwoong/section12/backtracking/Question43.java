package jinwoong.section12.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Question43 {
    /**
     * 1부터 N까지 숫자중 합이 10이 되는 조합 구하기
     * <p>
     * 제약 조건 <br/>
     * 1. 백트래킹 활용 <br/>
     * 2. 숫자 조합은 오름차순으로 정렬 <br/>
     * 3. 같은 숫자는 한 번만 선택 가능
     * </p>
     * @param n 1 이상 10 이하인 정수
     * @return 합이 10이 되는 조합
     */

    static final int TARGET = 10;

    public List<List<Integer>> solution(int n) {
        List<List<Integer>> validCombinations = new ArrayList<>();
        backtrack(0, new ArrayList<>(), 1, validCombinations, n);

        return validCombinations;
    }

    public void backtrack(int sum, List<Integer> combination, int begin, List<List<Integer>> validCombinations, int n) {
        if (sum == TARGET) {
            validCombinations.add(combination);
            return;
        }

        for (int i = begin; i <= n; i++) {
            if (sum + i <= TARGET) {
                combination.add(i);
                backtrack(sum + i, combination, i + 1, validCombinations, n);
            }
        }
    }
}
