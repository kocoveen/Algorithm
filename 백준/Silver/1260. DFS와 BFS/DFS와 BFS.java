import java.util.*;

public class Main {
    
    static int N, M, V;
    static int[][] graph;

    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        dfs(new boolean[N+1]);
        sb.append("\n");
        bfs(new boolean[N+1]);
        System.out.print(sb);
    }

    private static void dfs(boolean[] visit) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(V);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (visit[u]) continue;
            visit[u] = true;
            sb.append(u).append(" ");

            for (int v = N; v >= 1; v--) {
                if (!visit[v] && graph[u][v] == 1) {
                    stack.push(v);
                }
            }
        }
    }

    private static void bfs(boolean[] visit) {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(V);
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            if (visit[u]) continue;
            visit[u] = true;

            sb.append(u).append(" ");

            for (int v = 1; v <= N; v++) {
                if (!visit[v] && graph[u][v] == 1) {
                    queue.add(v);
                }
            }
        }
    }
}