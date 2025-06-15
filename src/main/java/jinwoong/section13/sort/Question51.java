package jinwoong.section13.sort;

public class Question51 {
    /**
     * 정렬이 완료된 두 배열 합치기
     * <p>
     * 제약 조건: arr1과 arr2의 길이는 1 이상 100,000 이하
     * </p>
     * @param arr1 오름차순으로 정렬된 배열
     * @param arr2 오름차순으로 정렬된 배열
     * @return 병합 정렬 결과
     */
    int[] solution(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i += 1;
                k += 1;
                continue;
            }
            if (arr1[i] > arr2[j]) {
                merged[k] = arr2[j];
                j += 1;
                k += 1;
            }
        }

        /* 위의 과정에서 채워지지 않은 남은 부분 처리 */
        while (i < arr1.length) {
            merged[k] = arr1[i];
            i += 1;
            k += 1;
        }

        while (j < arr2.length) {
            merged[k] = arr2[j];
            j += 1;
            k += 1;
        }

        return merged;
    }


}
