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
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(l[i - 1]);

        dp[0] = arr[0];
        for (int i = 1; i <= N; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++)
                if (arr[i] > arr[j])
                    tmp = Math.max(dp[j], tmp);
            dp[i] = tmp + 1;
        }

        for (int i = 1; i <= N; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}