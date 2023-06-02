import java.io.*;

public class Main {

    static int N, max;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        dp = new Integer[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        System.out.println(func(N));
    }

    private static int func(int n) {
        if (n <= 0) return 0;
        if (n == 1) return arr[1];

        if (dp[n] == null)
            dp[n] = Math.max(func(n - 1), Math.max(func(n - 2), arr[n - 1] + func(n - 3)) + arr[n]);
        
        return dp[n];
    }
}