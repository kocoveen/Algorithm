import java.util.HashSet;
import java.util.Set;

public class Main {
    static int N, R;
    static Set<Info>[] graph;
    static boolean[] visited;
    static int c, b;

    static class Info {
        int v, d;
        public Info(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public String toString() {
            return "%d".formatted(v);
        }
    }

    public static void main(String[] args) throws Exception {
        N = read(); R = read();

        graph = new Set[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new HashSet<>();
        }

        visited = new boolean[N + 1];
        for (int i = 1; i < N; i++) {
            int u = read();
            int v = read();
            int d = read();
            graph[u].add(new Info(v, d));
            graph[v].add(new Info(u, d));
        }

        visited[R] = true;
        traversalTrunk(0, R);
        System.out.printf("%d %d", c, b);
    }

    private static void traversalTrunk(int size, int node) {
        int children = getChildren(node);
        if (children != 1) {
            c = size;
            if (children >= 2) {
                traversalBranch(true, 0, node);
            }
            return;
        }

        for (Info info : graph[node]) {
            if (visited[info.v]) {
                continue;
            }
            visited[info.v] = true;
            traversalTrunk(size + info.d, info.v);
            visited[info.v] = false;
        }
    }

    private static int getChildren(int node) {
        return graph[node].size() 
            - (int) graph[node].stream().filter(i -> visited[i.v]).count();
    }

    private static void traversalBranch(boolean isFirst, int size, int node) {
        int children = graph[node].size() - 1;
        if (children == 0) {
            b = Math.max(b, size);
            return;
        }

        for (Info info : graph[node]) {
            if (visited[info.v]) {
                continue;
            }
            visited[info.v] = true;
            traversalBranch(isFirst, size + info.d, info.v);
            visited[info.v] = false;
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}