import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] line;

    static int N, M;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        line = br.readLine().split(" ");
        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(line[i - 1]);

        // length 1
        for (int i = 1; i <= N; i++) dp[i][i] = 1;
        // length 2
        for (int i = 1; i < N; i++) if (arr[i] == arr[i + 1]) dp[i][i + 1] = 1;

        // length n;
        for (int l = 3; l <= N; l++) 
            for (int s = 1; s <= N - l + 1; s++) 
                if (arr[s] == arr[s + l - 1] && dp[s + 1][s + l - 2] == 1)
                    dp[s][s + l - 1] = 1;

        M = Integer.parseInt(br.readLine());
        for (int i = 1; i <= M; i++) {
            line = br.readLine().split(" ");
            int s = Integer.parseInt(line[0]);
            int e = Integer.parseInt(line[1]);
            sb.append(dp[s][e]).append('\n');
        }

        System.out.print(sb);

    }
}