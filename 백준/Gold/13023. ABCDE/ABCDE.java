import java.util.*;

public class Main {
    
    static int N, M;
    static List<Integer>[] graph;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 0, new HashSet<>());
        }
        System.out.println(0);
    }

    private static void dfs(int i, int dep, Set<Integer> vis) {
        if (dep == 5) {
            if (vis.size() == 5) {
                System.out.println(1);
                System.exit(0);
            }
            return;
        }

        for (int next : graph[i]) {
            if (!vis.contains(next)) {
                vis.add(next);
                dfs(next, dep + 1, vis);
                vis.remove(next);
            }
        }
    }
}