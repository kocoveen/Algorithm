import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;
    static int T, N;

    static int[][] stickers;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            stickers = new int[3][N + 1];
            dp = new int[3][N + 1];

            for (int i = 1; i <= 2; i++) {
                l = br.readLine().split(" ");
                for (int j = 1; j <= N; j++)
                    stickers[i][j] = Integer.parseInt(l[j - 1]);
            }

            dp[1][1] = stickers[1][1];
            dp[2][1] = stickers[2][1];

            for (int j = 2; j <= N; j++) {
                for (int i = 1; i <= 2; i++) {

                    int max = 0;
                    max = Math.max(max, dp[1][j - 2]);
                    max = Math.max(max, dp[2][j - 2]);
                    if (i == 1) max = Math.max(max, dp[2][j - 1]);
                    else max = Math.max(max, dp[1][j - 1]);

                    dp[i][j] = max + stickers[i][j];
                }
            }
            sb.append(Math.max(dp[1][N], dp[2][N])).append('\n');
        }
        System.out.print(sb);
    }
}