package jinwoong.section07.queue;

import java.util.LinkedList;
import java.util.Queue;

/* 요세푸스 문제 - 백준 1158 (https://www.acmicpc.net/problem/1158) */
public class Josephus {
    public String solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder("<");

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            int out = queue.poll();
            sb.append(out)
                    .append(" ");
        }

        return sb.toString()
                       .trim()
                       .replace(" ", ", ") + ">";
    }
}
