import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    static int N, sum = 0;

    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N + 1];
        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) A[i] = Integer.parseInt(l[i]);

        Arrays.sort(A);
        for (int i = 1; i <= N; i++) dp[i] = dp[i - 1] + A[i - 1];
        
        for (int i : dp) sum += i;
        System.out.println(sum);
    }
}