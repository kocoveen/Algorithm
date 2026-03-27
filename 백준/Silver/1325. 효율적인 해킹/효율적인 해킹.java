import java.util.*;

public class Main {
    
    static int N, M;
    static List<Integer>[] graph;
    static int[] visit;

    static Integer[] children;
    
    public static void main(String[] args) throws Exception {
        N = read();
        M = read();

        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        children = new Integer[N+1];
        visit = new int[N+1];

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();

            graph[v].add(u);
        }
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            children[i] = getChildrenCountOf(i);
            max = Math.max(max, children[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (children[i] != max) continue;
            sb.append(i).append(" ");
        }
        System.out.print(sb);
    }

    private static int getChildrenCountOf(int u) {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(u);
        visit[u] = u;
        int count = 0;

        while(!q.isEmpty()) {
            int poll = q.poll();
            for (int n : graph[poll]) {
                if (visit[n] != u) {
                    visit[n] = u;
                    q.add(n);
                    count++;
                }
            }
        }

        return count;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}