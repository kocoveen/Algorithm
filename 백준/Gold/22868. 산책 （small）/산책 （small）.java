import java.util.*;

public class Main {

    static int N, M;
    static int S, E;
    static List<Integer>[] map;
    static int[] par;
    static boolean[] sel;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); M = sc.nextInt();
        map = new List[N+1];
        sel = new boolean[N+1];
        par = new int[N+1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            map[u].add(v);
            map[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }

        S = sc.nextInt(); E = sc.nextInt();
        
        int dist = 0;
        dist += bfs(S, E);
        
        int cur = par[E];
        while (cur != S) {
            sel[cur] = true;
            cur = par[cur];
        }
        
        dist += bfs(E, S);

        System.out.print(dist);
    }

    private static int bfs(int U, int V) {
        boolean[] vis = new boolean[N+1];
        vis[U] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{U, 0});
        
        for (int i = 1; i <= N; i++)
            if (sel[i]) vis[i] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == V) return cur[1];

            for (int nxt : map[cur[0]]) {
                if (vis[nxt]) continue;
                
                q.add(new int[]{nxt, cur[1] + 1});
                par[nxt] = cur[0];
                vis[nxt] = true;
            }
        }
        return 0;
    }
}