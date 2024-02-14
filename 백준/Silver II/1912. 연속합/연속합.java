import java.io.*;

public class Main {
    static String[] l;

    static int N, max = Integer.MIN_VALUE;

    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new Integer[N + 1];
        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(l[i]);

        dp[0] = arr[0];
        for (int i = 1; i < N; i++)
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);

        for (int i = 0; i < N; i++) {
            max = Math.max(dp[i], max);
        }

        System.out.println(max);
    }
}