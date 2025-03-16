package jinwoong.section05.array;

import java.util.*;

/**
 * 정수 배열을 하나 받습니다. 배열의 중복값을 제거하고 배열 데이터를
 * 내림차순으로 정렬해서 반환하는 solution() 함수를 완성하세요.
 * <p>
 * 제약 조건 <br/>
 * 1. 정수 배열의 길이는 2 이상 1,000 이하입니다. <br/>
 * 2. 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하입니다.
 */
public class Question02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{4, 2, 2, 1, 3, 4})));
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 1, 3, 2, 5, 4})));
    }

    private static int[] solution(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        return set.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(x -> x)
                .toArray(); // chatGPT가 개선해줌

//        return Arrays.stream(set.toArray())
//                .map(x -> (Integer) x)
//                .sorted(Comparator.reverseOrder())
//                .mapToInt(x -> x)
//                .toArray();
    }

    private static int[] solution1ByAuthor(int[] arr) {
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new); // ❶ 중복값 제거
        Arrays.sort(result, Collections.reverseOrder());                                  // ❷ 내림차순 정렬
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();  // int형 배열로 변경 후 반환
    }

    /* IntStream에도 distinct() 메서드가 있음! 위의 코드에서 변형해본 것 */
    private static int[] solution2(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static int[] solution2ByAuthor(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        int[] result = new int[set.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = set.pollFirst();
        }
        // 이럴거면 TreeSet<>으로 받고 pollLast 해도 될 듯?

        return result;
    }

    /* 위의 코드 변형: 스트림 이용 */
    private static int[] solution3(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int num : arr) {
            set.add(num);
        }

        return set.stream()
                .mapToInt(x -> x)
                .toArray();
    }

    /* solution 노트
     *
     * 1. toArray()는 Object[] 반환 -> Integer[] 반환하려면 toArray(Integer[]::new)
     * 2. int[]에는 Comparator 사용 불가 (객체 타입에서만 작동)
     *
     * 다른 방법
     * return Arrays.stream(set.toArray(new Integer[0])) // Stream<Integer>
            .sorted(Comparator.reverseOrder())
            .mapToInt(x -> x)
            .toArray();
     */
}