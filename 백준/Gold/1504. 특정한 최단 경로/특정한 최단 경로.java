import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    static class Node {
        int v;
        int c;

        public Node(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }

    public static final int INF = 1_000_000;
    static int u1, u2;
    static int n, e;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        n = Integer.parseInt(split[0]); // 정점 수
        e = Integer.parseInt(split[1]); // 간선 수
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (e-- > 0) {
            split = br.readLine().split(" ");
            int v1 = Integer.parseInt(split[0]);
            int v2 = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            graph.get(v1).add(new Node(v2, c));
            graph.get(v2).add(new Node(v1, c));
        }
        split = br.readLine().split(" ");
        u1 = Integer.parseInt(split[0]);
        u2 = Integer.parseInt(split[1]);

        int[] u1_costs = dijkstra(u1);
        int[] u2_costs = dijkstra(u2);

        int answer = u1_costs[u2];
        if (answer >= INF || u1_costs[n] >= INF) {
            System.out.println(-1);
        } else if (u2_costs[n] + u1_costs[1] > u1_costs[n] + u2_costs[1]) {
            System.out.println(answer + u1_costs[n] + u2_costs[1]);
        } else {
            System.out.println(answer + u2_costs[n] + u1_costs[1]);
        }
    }

    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);

        int[] costs = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            costs[i] = INF;
        }

        pq.offer(new Node(start, 0));
        costs[start] = 0;
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();

            if (costs[curNode.v] < curNode.c) {
                continue;
            }

            for (Node nxtNode : graph.get(curNode.v)) {
                if (costs[nxtNode.v] > curNode.c + nxtNode.c) {
                    costs[nxtNode.v] = curNode.c + nxtNode.c;
                    pq.offer(new Node(nxtNode.v, costs[nxtNode.v]));
                }
            }
        }
        return costs;
    }

    private static void printCosts(int[] costs) {
        for (int i = 1; i < costs.length; i++) {
            System.out.print(costs[i] + " ");
        }
        System.out.println();
    }
}