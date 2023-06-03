import java.io.*;

public class Main {
    static String[] l;

    static int n, k;

    static int[] value;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        n = Integer.parseInt(l[0]);
        k = Integer.parseInt(l[1]);

        value = new int[10005];
        dp = new int[10005];
        for (int i = 0; i < n; i++) value[i] = Integer.parseInt(br.readLine());

        dp[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = value[i]; j <= k; j++)
                dp[j] += dp[j - value[i]];
        
        System.out.println(dp[k]);
    }
}