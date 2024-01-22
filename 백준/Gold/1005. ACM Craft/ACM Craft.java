import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int t, n, k, w;
    static int[] costs;
    static int[] fanIns;
    static int[] totalCosts;
    static List<Integer>[] childs;
    static Queue<Integer> q;

    public static void main(String[] args) throws Exception {
        t = read();
        while (t-- > 0) {
            n = read(); k = read();

            totalCosts = new int[n + 1];
            costs = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int cost = read();
                costs[i] = cost;
                totalCosts[i] = costs[i];
            }

            childs = new List[n + 1];
            for (int i = 1; i <= n; i++) {
                childs[i] = new ArrayList<>();
            }

            fanIns = new int[n + 1];
            while (k-- > 0) {
                int p = read();
                int c = read();
                childs[p].add(c);
                fanIns[c]++;
            }

            w = read();

            // 위상 정렬
            q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (fanIns[i] == 0) {
                    q.add(i);
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int i : childs[cur]) {
                    totalCosts[i] = Math.max(totalCosts[i], costs[i] + totalCosts[cur]);
                    fanIns[i]--;
                    if (fanIns[i] == 0) {
                        q.add(i);
                    }
                }
            }
            System.out.println(totalCosts[w]);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}