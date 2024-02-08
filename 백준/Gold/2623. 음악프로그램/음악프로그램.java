import java.util.*;

public class Main {

    static int n, m;
    static int[] fanIns;
    static List<Integer>[] graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read(); m = read();
        graph = new List[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        fanIns = new int[n + 1];
        while (m-- > 0) {
            int k = read();
            int parent = read();
            while (--k > 0) {
                int child = read();
                graph[parent].add(child);
                fanIns[child]++;
                parent = child;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) if (fanIns[i] == 0) q.add(i);
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i : graph[cur]) {
                fanIns[i]--;
                if (fanIns[i] == 0) q.add(i);
            }
            sb.append(cur).append(" ");
        }

        for (int i = 1; i <= n; i++) {
            if (fanIns[i] > 0) {
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(sb);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}