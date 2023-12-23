import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int v, e;
    static List<Integer>[] graph;
    static List<Edge> edges = new ArrayList<>();
    static int[] inst;

    public static void main(String[] args) throws Exception {
        v = read();
        e = read();

        graph = new List[v + 1];
        inst = new int[v + 1]; //연결된 부모 찾기
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
            inst[i] = -1;
        }

        for (int i = 0; i < e; i++) {
            int v1 = read();
            int v2 = read();
            int w = read();
            graph[v1].add(v2);
            graph[v2].add(v1);
            edges.add(new Edge(v1, v2, w));
        }
        Collections.sort(edges, (e1, e2) -> e1.w - e2.w);

        int sum = 0;
        for (Edge e : edges) {
            int vN1 = find(e.v1);
            int vN2 = find(e.v2);
            if (vN1 != vN2) {
                sum += e.w;
                union(vN1, vN2);
            }
        }
        System.out.println(sum);
    }

    private static void union(int r1, int r2) {
        if (r1 != r2) {
            inst[r2] = r1;
        }
    }

    private static int find(int v) {
        if (inst[v] == -1) return v;
        return inst[v] = find(inst[v]);
    }

    static class Edge {
        int v1, v2, w;

        public Edge(int v1, int v2, int w) {
            this.v1 = v1;
            this.v2 = v2;
            this.w = w;
        }
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}