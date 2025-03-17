package jinwoong.section05.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Question06 {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> rates = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int j = i; // lambda 식 쓰기 위한 유사-final 변수
            double arrived = (double) Arrays.stream(stages).filter(num -> num >= j).count();
            if (arrived == 0) { // 도달한 유저가 없으면 0
                rates.put(i, arrived);
            } else {
                rates.put(i, (double) Arrays.stream(stages).filter(num -> num == j).count() / arrived);
            }
        }
        return rates.keySet().stream()
                .sorted(Comparator.comparingDouble((Integer i) -> -rates.get(i))
                        .thenComparingInt(i -> i)) // 혹은 .thenComparing( (o1, o2) -> o1 - o2) )
                .mapToInt(x -> x)
                .toArray();

        // 아래와 같이 작성해도 여기서는 옳게 나오지만 key의 값이 65535를 초과하면 제대로 된 값이 나오지 않을 수 있음!
        // return rates.keySet().stream()
        //     .sorted(Comparator.comparingDouble(i -> -rates.get(i)))
        //     .mapToInt(x -> x)
        //     .toArray();
    }
}
