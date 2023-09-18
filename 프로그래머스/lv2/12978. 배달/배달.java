import org.w3c.dom.Node;

import java.util.*;

class Solution {
    boolean[] visited;
    int[] costs;
    List<List<Node>> network;
    int N;
    int K;
    static final int MAX = 1_000_000_000;

    public int solution(int N, int[][] roads, int K) {
        int answer = 0;
        this.N = N;
        this.K = K;

        visited = new boolean[N + 1];
        costs = new int[N + 1];

        network = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            network.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int t1 = road[0];
            int t2 = road[1];
            int c = road[2];
            network.get(t1).add(new Node(t2, c));
            network.get(t2).add(new Node(t1, c));
        }

//         // network
//         for (int i = 1; i <= N; i++) {
//             System.out.printf("[%d] -> ", i);
//             for (Node node : network.get(i)) {
//                 System.out.printf("[%d(%d)], ", node.endpoint, node.cost);
//             }
//             System.out.println("\b\b}");
//         }

        visited[1] = true;
        costs[1] = 1;
        dfs(1, 0);

        // // network
        // for (int i : costs) {
        //     System.out.printf("%d ", i);
        // }
        // System.out.println();

        for (int c : costs) {
            if (c == 1) answer++;
        }

        return answer;
    }

    private void dfs(int cur, int curCost) {
        for (Node node : network.get(cur)) {
            int i = node.endpoint;
            if (visited[i]) continue;
            int cost = curCost + node.cost;
            if (cost > K) continue;
            visited[i] = true;
            costs[i] = 1;
            dfs(i, cost);
            visited[i] = false;
        }
    }

    static class Node {
        int endpoint;
        int cost;

        public Node(int endpoint, int cost) {
            this.endpoint = endpoint;
            this.cost = cost;
        }
    }
}