import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static String[] l;
    static int T, N, M;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            l = br.readLine().split(" ");
            M = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[M + 1];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(l[i]);

            dp[0] = 1;
            for (int i = 0; i < N; i++)
                for (int j = arr[i]; j <= M; j++)
                    dp[j] += dp[j - arr[i]];
            sb.append(dp[M]).append('\n');
        }
        System.out.print(sb);
    }
}