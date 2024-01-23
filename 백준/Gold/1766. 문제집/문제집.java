import java.util.*;

public class Main {

    static int n, m;
    static int[] fanIns;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        graph = new List[n + 1];
        fanIns = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        while (m-- > 0) {
            int a = read();
            int b = read();
            graph[a].add(b);
            fanIns[b]++;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>((i1, i2) -> {
            if (fanIns[i1] != fanIns[i2]) return fanIns[i1] - fanIns[i2];
            return i1 - i2;
        });
        for (int i = 1; i <= n; i++) {
            if (fanIns[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            Integer cur = q.remove();
            sb.append(cur).append(' ');
            for (Integer i : graph[cur]) {
                fanIns[i]--;
                if (fanIns[i] == 0) {
                    q.add(i);
                }
            }
        }
        System.out.println(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}