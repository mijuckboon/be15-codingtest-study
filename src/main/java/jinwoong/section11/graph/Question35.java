package jinwoong.section11.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Question35 {
    /**
     * 너비 우선 탐색 순회
     * <p>
     * 제약 조건: 모든 노드를 방문할 수 있는 경로가 항상 있음
     * </p>
     * @param graph (출발 노드, 도착 노드) 쌍의 리스트
     * @param start 시작 노드
     * @param n 노드의 수 (최대 100)
     * @return 깊이 우선 탐색 결과: 노드를 순서대로 나열한 배열
     */
    public int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트 구성
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            int from = edge[0];
            int to = edge[1];
            adjList.get(from).add(to);
        }

        // 방문 배열
        boolean[] visited = new boolean[n + 1];
        List<Integer> bfsResult = new ArrayList<>();
        bfs(start, visited, bfsResult, adjList);

        return bfsResult.stream().mapToInt(x -> x).toArray();
        // input이 String이었을 때:
        // return dfsResult.toArray(new String[0]); // 아래처럼 String[]::new도 가능
        // return dfsResult.stream().toArray(String[]::new);
   }
   private void bfs(int start, boolean[] visited, List<Integer> bfsResult, List<List<Integer>> adjList) {
       Queue<Integer> queue = new ArrayDeque<>();
       queue.add(start);
       visited[start] = true; // 방문

       while (!queue.isEmpty()) {
           int current = queue.poll();
           bfsResult.add(current); // 처리

           for (int next : adjList.get(current)) {
               if (!visited[next]) {
                   queue.add(next);
                   visited[next] = true; // 방문
               }
           }
       }

   }
}
