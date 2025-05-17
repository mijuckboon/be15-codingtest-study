package jinwoong.section11.graph;

import java.util.*;

public class Question36 {
    //    static final int INF = 10001; 거리의 합이므로 더 커질 수 있음
    static final int INF = Integer.MAX_VALUE;

    /**
     * 다익스트라 알고리즘
     * <p>
     * 제약 조건: 각 노드는 0 이상 10000 이하의 정수
     * 모든 가중치는 0 이상 10000 이하의 정수
     * </p>
     *
     * @param graph (출발 노드, 도착 노드, 가중치) 쌍의 리스트
     * @param start 시작 노드
     * @param n     노드의 수 (최대 10000)
     * @return 시작 노드붵 시작 노드를 포함한 모든 노드까지의 최단 거리를 순서대로 저장한 배열
     */
    public int[] solution(int[][] graph, int start, int n) {
        // 인접 리스트 초기화
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : graph) {
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
        }

        // 거리 배열 초기화
        int[] distances = new int[n];
        Arrays.fill(distances, INF);
        distances[start] = 0;

        // 우선순위 큐: 거리 기준 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.cost));
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();

            // 더 짧은 경로로 이미 방문한 경우 무시
            if (distances[currentNode.id] < currentNode.cost) continue;

            for (Node nextNode : adjList.get(currentNode.id)) {
                int newDist = distances[currentNode.id] + nextNode.cost;
                if (distances[nextNode.id] > newDist) {
                    distances[nextNode.id] = newDist;
                    pq.add(new Node(nextNode.id, newDist));
                }
            }
        }

        return distances;
    }

    private static class Node {
        int id;
        int cost;

        public Node(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }
    }

}
