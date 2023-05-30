import java.io.*;

public class Main {

    static int[] dp = new int[15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 4; i <= n; i++)
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            System.out.println(dp[n]);
        }
    }
}