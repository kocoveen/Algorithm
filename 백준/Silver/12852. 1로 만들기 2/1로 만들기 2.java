import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int N, M, cnt;

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dp = new Integer[1000005];
        dp[0] = 0;
        dp[1] = 0;
        cnt = func(N);
        System.out.println(cnt);

        arr = new int[cnt + 1];
        arr[0] = N;
        func2(0, N, 0);
        for (int i : arr) System.out.printf("%d ", i);
    }

    private static int func(int n) {
        if (dp[n] == null) {
            if (n % 6 == 0)
                dp[n] = Math.min(func(n / 3), Math.min(func(n / 2), func(n - 1))) + 1;
            else if (n % 3 == 0)
                dp[n] = Math.min(func(n / 3), func(n - 1)) + 1;
            else if (n % 2 == 0)
                dp[n] = Math.min(func(n / 2), func(n - 1)) + 1;
            else
                dp[n] = func(n - 1) + 1;
        }
        return dp[n];
    }

    private static void func2(int depth, int n, int prev) {
        if (depth == -1) return;
        if (depth != 0 && dp[prev] - 1 != dp[n]) return;

        arr[depth] = n;
        if (n % 3 == 0) func2(depth + 1, n / 3, n);
        if (n % 2 == 0) func2(depth + 1, n / 2, n);
        func2(depth + 1, n - 1, n);
    }

}
