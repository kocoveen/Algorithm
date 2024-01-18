import java.io.*;
import java.util.*;

public class Main {

    static final int C = 400001;
    static int n, mn = C;
    static int[] steps;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = line.length - 1;
        steps = new int[line.length];
        for (int i = 1; i <= n; i++) {
            steps[i] = Integer.parseInt(line[i - 1]);
        }

        dp = new int[5][5][n + 1];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], C);
            }
        }

        dp[0][0][0] = 0;
        for (int k = 0; k < n; k++) {
            int next = steps[k + 1];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    dp[next][j][k + 1] = Math.min(dp[next][j][k + 1], getForce(i, next) + dp[i][j][k]);
                    dp[i][next][k + 1] = Math.min(dp[i][next][k + 1], getForce(j, next) + dp[i][j][k]);
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                mn = Math.min(mn, dp[i][j][n]);
            }
        }
        System.out.println(mn);
    }

    private static int getForce(int prev, int next) {
        if (prev == next) return 1;
        else if (prev == 0) return 2;
        else if ((prev + next) % 2 == 1) return 3;
        return 4;
    }
}