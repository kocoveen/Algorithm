import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
    static int K, V, E;
    static List<Integer>[] graph;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        K = read();

        while (K-- > 0) {
            V = read(); E = read();
            graph = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 1; i <= E; i++) {
                int a = read(); int b = read();
                graph[a].add(b);
                graph[b].add(a);
            }

            Deque<Integer> q = new ArrayDeque<>();
            boolean flag = false;
            for (int j = 1; j <= V; j++) {
                if (colors[j] != 0) continue;
                q.add(j); colors[j] = 1;
                while (!q.isEmpty()) {
                    Integer i = q.remove();
                    for (Integer s : graph[i]) {
                        if (colors[i] != 0 && colors[i] == colors[s]) flag = true;
                        if (colors[s] > 0) continue;
                        q.add(s); colors[s] = colors[i] == 1 ? 2 : 1;
                    }
                }
            }

            if (flag) System.out.println("NO");
            else System.out.println("YES");
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}