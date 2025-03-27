package jinwoong.section08.hash;

import java.util.HashSet;
import java.util.Set;

public class Question18 {
    /**
     * 두 개의 수로 특정값 만들기
     * @param arr n개의 양의 정수로 이루어진 배열
     * @param target 정수
     * @return 합이 target인 두 수가 arr에 있으면 {@code true}, 없으면 {@code false}
     */
    boolean solution(int[] arr, int target) {
        Set<Integer> searched = new HashSet<>();
        for (int num : arr) {
            if (searched.contains(target - num)) {
                return true;
            }
            searched.add(num);
        }
        return false;
    }
}
