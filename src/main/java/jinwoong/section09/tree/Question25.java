package jinwoong.section09.tree;

public class Question25 {
    /**
     * 전위 순회, 중위 순회, 휘위 순회 결과를 반환
     * @param nodes 이진 트리를 표현한 배열
     * @return 순회 결과 리스트
     */
    String[] solution(int[] nodes) {
        String[] results = new String[3];

        results[0] = preorder(nodes, 0).trim();
        results[1] = inorder(nodes, 0).trim();
        results[2] = postorder(nodes, 0).trim();
        return results;
    }

    private String preorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        // 루트 노드 인덱스가 1이면 -1씩
        return nodes[idx] + " " + preorder(nodes, 2 * idx + 1) + preorder(nodes, 2 * idx + 2);
    }

    private String inorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return inorder(nodes, 2 * idx + 1) + nodes[idx] + " " + inorder(nodes, 2 * idx + 2);
    }

    private String postorder(int[] nodes, int idx) {
        if (idx >= nodes.length) {
            return "";
        }

        return postorder(nodes, 2 * idx + 1) + postorder(nodes, 2 * idx + 2) + nodes[idx] + " ";
    }



}
