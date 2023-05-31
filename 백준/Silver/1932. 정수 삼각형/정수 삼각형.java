import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int n;

    static int[][] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];

        for (int i = n - 1; i >= 0; i--) {
            l = br.readLine().split(" ");
            for (int j = 0; j < l.length; j++) {
                arr[i][j] = Integer.parseInt(l[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j + 1]) + arr[i][j];
            }
        }

        System.out.println(dp[n - 1][0]);
    }
}