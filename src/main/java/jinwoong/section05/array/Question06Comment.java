package jinwoong.section05.array;

import java.util.*;

public class Question06Comment {
    public static void main(String[] args) {
        Map<Integer, Double> rates = new HashMap<>();
        rates.put(70000, 0.1);
        rates.put(90000, 0.1);
        rates.put(80000, 0.1);
        rates.put(60000, 0.1);
        rates.put(50000, 0.1);

        List<Integer> result = new ArrayList<>(rates.keySet());
        result.sort(Comparator.comparingDouble(i -> -rates.get(i))); // 실패율 기준 정렬 (두 번째 조건 없음)

        System.out.println(result); // 기대하는 순서 [50000, 60000, 70000, 80000, 90000]
        // 실제 순서 [60000, 50000, 70000, 90000, 80000]
    }
}
