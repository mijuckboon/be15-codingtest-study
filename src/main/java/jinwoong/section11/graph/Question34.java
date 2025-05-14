package jinwoong.section11.graph;

import java.util.*;

public class Question34 {
    /**
     * 깊이 우선 탐색 순회
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
        List<Integer> dfsResult = new ArrayList<>();
        dfs(start, visited, dfsResult, adjList);

        return dfsResult.stream().mapToInt(x -> x).toArray();
        // input이 String이었을 때:
        // return dfsResult.toArray(new String[0]); // 아래처럼 String[]::new도 가능
        // return dfsResult.stream().toArray(String[]::new);
   }
   private void dfs(int now, boolean[] visited, List<Integer> dfsResult, List<List<Integer>> adjList) {
        visited[now] = true; // 방문
        dfsResult.add(now); // 처리

        for (int next: adjList.get(now)) {
            if (!visited[next]) {
                dfs(next, visited, dfsResult, adjList);
            }
        }
   }
}
