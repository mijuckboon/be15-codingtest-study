package jinwoong.section15.dp;

import java.util.Arrays;

public class Question68 {
    /**
     * LIS 길이 계산하기
     * <p>
     * 제약 조건: nums의 각 요소는 -1,000 이상 1,000 이하의 정수
     * </p>
     * @param nums 최대 길이 1,000의 정수 배열
     * @return LIS의 길이
     */
    int solution2(int[] nums) {
        int[] lis = new int[nums.length + 1];
        Arrays.fill(lis, 1);

        for (int i = 1; i < lis.length; i++) {
            for (int j = 1; j <= i; j++) {
                if (nums[i - 1] > nums[j - 1]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }

        }

        return Arrays.stream(lis).max().getAsInt();
    }

    int solution(int[] nums) {
        int[] numbers = new int[nums.length + 1];
        numbers[0] = Integer.MIN_VALUE;
        System.arraycopy(nums, 0, numbers, 1, nums.length);

        int[] lis = new int[nums.length + 1];

        for (int i = 1; i < lis.length; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }

        }

        return Arrays.stream(lis).max().getAsInt();
    }

}
