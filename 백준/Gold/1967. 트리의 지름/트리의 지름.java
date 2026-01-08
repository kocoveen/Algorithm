import java.util.HashSet;
import java.util.Set;

public class Main {
    static class Node {
        int num, cost;
        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    static Set<Node>[] graph;
    static boolean[] visited;
    static int maxCost, maxNum;

    public static void main(String[] args) throws Exception {
        int n = read();
        graph = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = read();
            int v = read();
            int cost = read();

            graph[u].add(new Node(v, cost));
            graph[v].add(new Node(u, cost));
        }

        visited = new boolean[n + 1];
        visited[1] = true;
        traversal(1, 0);
        
        visited = new boolean[n + 1];
        visited[maxNum] = true;
        traversal(maxNum, 0);
        System.out.println(maxCost);
    }

    private static void traversal(int num, int cost) {
        if (maxCost < cost) {
            maxCost = cost;
            maxNum = num;
        }

        for (Node n : graph[num]) {
            if (visited[n.num]) continue;
            visited[n.num] = true;
            traversal(n.num, cost + n.cost);
            visited[n.num] = false;
        }
    } 

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}