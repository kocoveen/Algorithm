import java.util.*;

public class Main {

    static final int INF = 987654321;
    static int n, k, u, v, t, size;
    static List<Node>[] graph;
    static class Node {
        int idx, cost, residual;

        public Node(int idx, int cost, int residual) {
            this.idx = idx;
            this.cost = cost;
            this.residual = residual;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        size = n + 2;
        k = sc.nextInt();

        graph = new List[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }

        while (k-- > 0) {
            u = sc.nextInt();
            v = sc.nextInt();
            t = sc.nextInt();
            if (t > 100) continue;
            graph[u].add(new Node(v, t, 0));
            graph[v].add(new Node(u, t, 0));
        }

        int enCosts = dijkstra(0, n + 1);
        System.out.println(enCosts);
    }

    private static int dijkstra(int st, int en) {
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.cost - n2.cost);
        pq.add(new Node(st, 0, 100));


        int[][] costs = new int[size][101];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 101; j++) {
                costs[i][j] = INF;
            }
        }
        
        costs[st][100] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.remove();

            if (costs[cur.idx][cur.residual] < cur.cost) continue;
            costs[cur.idx][cur.residual] = cur.cost;

            for (Node nxt : graph[cur.idx]) {

                if (cur.residual >= nxt.cost) {
                    if (costs[nxt.idx][cur.residual - nxt.cost] > cur.cost + nxt.cost) {
                        pq.add(new Node(nxt.idx, cur.cost + nxt.cost, cur.residual - nxt.cost));
                        costs[nxt.idx][cur.residual - nxt.cost] = cur.cost + nxt.cost;
                    }

                } else {
                    if (costs[nxt.idx][100 - nxt.cost] > cur.cost + nxt.cost + 5) {
                        pq.add(new Node(nxt.idx, cur.cost + nxt.cost + 5, 100 - nxt.cost));
                        costs[nxt.idx][100 - nxt.cost] = cur.cost + nxt.cost + 5;
                    }
                }

            }
        }

        int min = INF;
        for (int i = 0; i < 101; i++) {
            min = Math.min(min, costs[en][i]);
        }
        return min;
    }
}