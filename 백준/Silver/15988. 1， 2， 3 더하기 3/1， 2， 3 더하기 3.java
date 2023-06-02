import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int T, N; 
    static long C =  1000000009;

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            sb.append(func(N)).append('\n');
        }
        System.out.print(sb);
    }

    private static long func(int n) {
        if (dp[n] == 0) {
            dp[n] = (func(n - 1) % C + func(n - 2) % C + func(n - 3) % C) % C;
        }
        return dp[n];
    }
}