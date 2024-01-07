import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int n, m, mx;
    static List<Integer>[] graph;
    static boolean[] visit;
    static Integer[] count;
    static Queue<Integer> q;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        graph = new List[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = read();
            int b = read();
            graph[b].add(a);
        }

        count = new Integer[n+1];
        for (int i = 1; i <= n; i++) {
            count[i] = getTrustCompany(i);
            mx = Math.max(mx, count[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (count[i] == mx) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int getTrustCompany(int num) {
        if (count[num] != null) {
            return count[num];
        }

        int cnt = 0;
        visit = new boolean[n+1];
        q = new LinkedList<>();
        q.add(num);
        visit[num] = true;
        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int i : graph[cur]) {
                if (visit[i]) continue;
                q.add(i);
                cnt++;
                visit[i] = true;
            }
        }

        count[num] = cnt;
        return cnt;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}