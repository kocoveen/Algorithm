import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static String[] l;
    static int N, M;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);
        arr = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            l = br.readLine().split("");
            for (int j = 1; j <= M; j++)
                arr[i][j] = Integer.parseInt(l[j - 1]);
        }

        int ans = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = findMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans * ans);
    }

    private static int findMin(int... ints) {
        int min = Integer.MAX_VALUE;
        for (int i : ints) if (min > i) min = i;
        return min;
    }
}