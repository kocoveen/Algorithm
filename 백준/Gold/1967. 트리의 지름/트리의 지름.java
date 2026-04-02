import java.util.*;

public class Main {
    static int n;
    static List<int[]>[] graphs;
    static int cost, max, maxIndex;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graphs = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < n-1; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            int v = sc.nextInt();

            graphs[p].add(new int[]{c, v});
            graphs[c].add(new int[]{p, v});
        }

        boolean[] v = new boolean[n+1];
        v[0] = true;
        v[1] = true;
        dfs(1, v);

        v[1] = false;
        v[maxIndex] = true;
        dfs(maxIndex, v);
        int l = max;

        System.out.print(l);
    }

    private static void dfs(int p, boolean[] v) {
        for (int[] c : graphs[p]) {
            if (v[c[0]]) continue;
            v[c[0]] = true;
            cost += c[1];
            dfs(c[0], v);

            if (max < cost) {
                max = cost;
                maxIndex = c[0];
            }

            cost -= c[1];
            v[c[0]] = false;
        }
    }
}