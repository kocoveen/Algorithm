import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        Arrays.stream(wires).forEach(wire -> {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        });

        for (int[] wire : wires) {
            int network1 = bfs(wire[0], wire[1], new boolean[n + 1], tree);
            int network2 = bfs(wire[1], wire[0], new boolean[n + 1], tree);
            answer = Math.min(Math.abs(network1 - network2), answer);
        }

        return answer;
    }

    private int bfs(int node1, int node2, boolean[] visited, List<List<Integer>> tree) {
        Queue<Integer> Q = new LinkedList<>();
        int count = 0;
        Q.add(node1);
        visited[node1] = true;

        while (!Q.isEmpty()) {
            int cur = Q.remove();
            count++;
            for (int node : tree.get(cur)) {
                if (visited[node] || node == node2) continue;
                Q.add(node);
                visited[node] = true;
            }
        }
        return count;
    }
}