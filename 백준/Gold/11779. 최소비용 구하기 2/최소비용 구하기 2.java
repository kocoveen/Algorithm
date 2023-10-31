import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int num, c;
        public Node(int num, int c) {
            this.num = num;
            this.c = c;
        }
    }

    static final int INF = 100000001;
    static int n, m;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] cost, route;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        while (m-- > 0) {
            String[] split = br.readLine().split(" ");
            int f = Integer.parseInt(split[0]);
            int t = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);
            graph.get(f).add(new Node(t, c));
        }

        String[] split = br.readLine().split(" ");
        int f = Integer.parseInt(split[0]);
        int t = Integer.parseInt(split[1]);
        dijkstra(f);

        List<Integer> routes = new ArrayList<>();
        int cur = t;
        while (cur != 0) {
            routes.add(cur);
            cur = route[cur];
        }

        System.out.println(cost[t]);
        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    private static void dijkstra(int f) {
        cost = new int[n + 1];
        Arrays.fill(cost, INF);

        // 직전 노드의 num 저장
        route = new int[n + 1];
        route[f] = 0;

        // 비용 기준 오름차순
        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.c - n2.c);
        pq.offer(new Node(f, 0));
        cost[f] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cost[cur.num] < cur.c) continue;

            for (Node nxt : graph.get(cur.num)) {
                if (cost[nxt.num] > cur.c + nxt.c) {
                    cost[nxt.num] = cur.c + nxt.c;
                    pq.offer(new Node(nxt.num, cost[nxt.num]));
                    route[nxt.num] = cur.num;
                }
            }
        }
    }
}