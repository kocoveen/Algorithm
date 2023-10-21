import java.io.*;
import java.util.Arrays;

public class Main {
    public static final int INF = 100_000_000;
    static int[][] dists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]); // 학생 수
        int m = Integer.parseInt(split[1]); // 단방향 도로 수
        int x = Integer.parseInt(split[2]); // 도착 마을

        dists = new int[n + 1][n + 1];
        for (int[] d : dists) {
            Arrays.fill(d, INF);
        }

        for (int i = 1; i <= m; i++) {
            split = br.readLine().split(" ");
            int s = Integer.parseInt(split[0]); // 시작 마을
            int e = Integer.parseInt(split[1]); // 도착 마을
            int t = Integer.parseInt(split[2]); // 걸리는 시간
            dists[s][e] = t;
        }

        for (int i = 1; i <= n; i++) {
            dijkstra(i, n);
        }

        int mx = 0;
        for (int i = 1; i <= n; i++) {
            if (i == x) continue;
            mx = Math.max(mx, dists[i][x] + dists[x][i]);
        }
        System.out.println(mx);

    }

    private static void dijkstra(int start, int n) {
        boolean[] v = new boolean[n + 1];
        int[] d = Arrays.copyOf(dists[start], n + 1);

        d[start] = 0;
        v[start] = true;

        for (int i = 1; i <= n; i++) {
            int cur = getMinDistIndex(d, v, n);
            v[cur] = true;
            for (int j = 1; j <= n; j++) {
                if (!v[j]) {
                    if (d[cur] + dists[cur][j] < d[j]) {
                        d[j] = d[cur] + dists[cur][j];
                    }
                }
            }
        }
        dists[start] = d;
    }

    private static int getMinDistIndex(int[] d, boolean[] v, int n) {
        int min = 2 * INF, minIdx = 0;
        for (int i = 1; i <= n; i++) {
            if(d[i] < min && !v[i]) {
                min = d[i];
                minIdx = i;
            }
        }
        return minIdx;
    }
}