import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = sc.nextInt();
        dp = new Integer[N];

        int max = IntStream.range(0, N)
                           .map(i -> dp(i))
                           .max()
                           .orElse(0);

        System.out.print(N - max);
    }

    private static int dp(int n) {
        if (n < 0) return 1;
        if (dp[n] != null) return dp[n]; 
        return dp[n] = IntStream.range(0, n)
                            .filter(i -> arr[i] < arr[n])
                            .map(i -> dp(i))
                            .max()
                            .orElse(0) + 1;
    }
}