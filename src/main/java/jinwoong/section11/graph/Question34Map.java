package jinwoong.section11.graph;

import java.util.*;

/* 문자열 -> 인접 리스트로 맵 사용 */

public class Question34Map {
    public static void main(String[] args) {
        String[][] graph1 = {{"1", "2"}, {"2", "3"}, {"3", "4"}, {"4", "5"}};
        System.out.println(Arrays.toString(solution(graph1, "1")));

        String[][] graph2 = {{"1", "2"}, {"1", "3"}, {"2", "4"}, {"2", "5"}, {"3", "6"}, {"5", "6"}};
        System.out.println(Arrays.toString(solution(graph2, "1")));

        String[][] graph3 = {{"A", "B"}, {"B", "C"}, {"C", "D"}, {"D", "E"}}; // graph1에 대응되는 문자열 케이스
        System.out.println(Arrays.toString(solution(graph3, "A")));

        String[][] graph4 = {{"A", "B"}, {"A", "C"}, {"B", "D"}, {"B", "E"}, {"C", "F"}, {"E", "F"}};
        System.out.println(Arrays.toString(solution(graph4, "A")));

        String[][] graph5 = {{"1", "3"}, {"3", "5"}, {"5", "7"}, {"7", "9"}}; // graph 1에 대응되는 홀수 노드 케이스
        System.out.println(Arrays.toString(solution(graph5, "1")));

        String[][] graph6 = {{"1", "3"}, {"1", "5"}, {"3", "7"}, {"3", "9"}, {"5", "11"}, {"9", "11"}};
        System.out.println(Arrays.toString(solution(graph6, "1")));

    }

    // 인접 리스트
    private static Map<String, List<String>> adjList;

    // 방문 여부
    private static Set<String> visited;

    // 결과 리스트
    private static List<String> answer;

    public static String[] solution(String[][] graph, String start) {
        adjList = new HashMap<>();

        // 그래프 구성
        for (String[] edge : graph) {
            String from = edge[0];
            String to = edge[1];

            adjList.putIfAbsent(from, new ArrayList<>());
            adjList.get(from).add(to);
        }

        visited = new HashSet<>();
        answer = new ArrayList<>();

        dfs(start);

        return answer.toArray(new String[0]);
    }

    private static void dfs(String now) {
        visited.add(now);
        answer.add(now);

        List<String> neighbors = adjList.getOrDefault(now, Collections.emptyList());
        for (String next : neighbors) {
            if (!visited.contains(next)) {
                dfs(next);
            }
        }
    }
}