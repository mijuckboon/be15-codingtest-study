package jinwoong.section05.array;

import java.util.Arrays;

/**
 * 정수 배열을 정렬해서 반환하는 `solution()` 함수를 완성하세요.
 * <p>
 * 제약 조건 <br/>
 * 1. 정수 배열의 길이는 2 이상 10^5 이하입니다. <br/>
 * 2. 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하입니다.
 *
 */
public class Question01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, -5, 2, 4, 3})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
        System.out.println(Arrays.toString(solution(new int[]{6, 1, 7})));
    }

    private static int[] solution(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }

    private static int[] solution2(int[] arr) { // 원본 배열 유지
        int[] clone = arr.clone();
        Arrays.sort(clone);
        return clone;
    }
}