import java.io.*;

public class Main {
    static String[] l;

    static Integer[] dp;
    static int C = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new Integer[1005];

        dp[1] = 1;
        dp[2] = 2;
        System.out.println(func(N));
    }

    private static int func(int n) {
        if (n == 1) return dp[1];
        if (dp[n] == null) {
            dp[n] = (func(n - 1) % C + func(n - 2) % C) % C;
        }
        return dp[n];
    }

}
