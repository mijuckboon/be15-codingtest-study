package jinwoong.section07.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * N명의 사람이 원 형태로 서 있습니다. 각 사람은 1부터 N까지 번호표를 갖고 있습니다. 그리고 임의의 숫자 K가 주어졌을 때 다음과 같이 사람을 없앱니다. <br/>
 * - 1번 번호표를 가진 사람을 기준으로 K번째 사람을 없앱니다. <br/>
 * - 없앤 사람 다음 사람을 기준으로 하고 다시 K번째 사람을 없앱니다. <br/>
 * N과 K가 주어질 때 마지막에 살아있는 사람의 번호를 반환하는 {@code solution()} 함수를 구현해주세요. <br/>
 * 제약 조건: N과 K는 1 이상 1000 이하의 자연수입니다.
 */
public class Question15 {
    public static void main(String[] args) {
        System.out.println(solution(5,2)); // expected: 3
    }

    private static int solution(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        int poll = 0;
        while (!queue.isEmpty()) {
            for (int i = 1; i <= k-1; i++) {
                queue.offer(queue.poll());
            }
            poll = queue.poll();
        }
        return poll;
    }
}
