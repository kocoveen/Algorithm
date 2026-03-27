import java.util.*;

public class Main {
    
    static int N;
    static Set<Integer>[] graph;
    static boolean[] visit;

    static int[] parent;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();

        graph = new HashSet[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }

        visit = new boolean[N+1];
        parent = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        fn();

        for (int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void fn() {
        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(1);

        while(!queue.isEmpty()) {
            int u = queue.poll();
            visit[u] = true;

            for (int v : graph[u]) {
                if (visit[v]) continue;
                parent[v] = u;
                queue.add(v);
            }
        }
    }
}