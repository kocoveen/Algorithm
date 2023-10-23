import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final int INF = 100000000;

    public static void main(String[] args) throws IOException {
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);
            int w = Integer.parseInt(st[2]);

            int[][] costs = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                Arrays.fill(costs[i], INF);
            }

            while (m-- > 0) {
                st = br.readLine().split(" ");
                int s = Integer.parseInt(st[0]);
                int e = Integer.parseInt(st[1]);
                int t = Integer.parseInt(st[2]);
                costs[s][e] = Math.min(costs[s][e], t);
                costs[e][s] = costs[s][e];
            }
            while (w-- > 0) {
                st = br.readLine().split(" ");
                int s = Integer.parseInt(st[0]);
                int e = Integer.parseInt(st[1]);
                int t = Integer.parseInt(st[2]);
                costs[s][e] = -t;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        costs[i][j] = Math.min(costs[i][k] + costs[k][j], costs[i][j]);
                    }
                }
            }
            if (isDecreased(costs)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            } 
        }
    }

    private static boolean isDecreased(int[][] costs) {
        for (int i = 1; i < costs.length; i++) {
            if (costs[i][i] < 0) {
                return true;
            }
        }
        return false;
    }
}