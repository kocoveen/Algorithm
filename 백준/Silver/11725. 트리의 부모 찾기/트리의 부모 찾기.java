import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        Set<Integer>[] graph = new HashSet[n + 1]; // 무향 그래프
        for (int i = 1; i <= n; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < n-1; i++) {
            int u = read();
            int v = read();
            graph[u].add(v);
            graph[v].add(u);
        }

        // 무향그래프를 이용해 부모 발견
        int[] parent = new int[n + 1];
        boolean[] visited = new boolean[n + 1]; // 방문 

        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(1);
        while (!q.isEmpty()) {
            int curr = q.removeFirst();
            visited[curr] = true;
            for (int next : graph[curr]) {
                if (visited[next]) continue;
                parent[next] = curr;
                q.addLast(next);
            }
        }

        for (int node = 2; node <= n; node++) {
            System.out.println(parent[node]);
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}