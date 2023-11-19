import java.io.*;

/**
 * 점화식
 * dp[i] -> i장의 카드를 사는데 드는 최소비용
 * values[i] -> i장의 묶음 카드를 사는데 드는 비용
 * dp[i] = min(dp[i-1] + values[1], dp[i-2] + values[2], dp[i-3] + values[3], ... dp[i] + dp[0])
 * 
 * i가 1일 때, 2일 때... 을 반복
 * 각 dp[i]를 갱신하며, 최소값을 찾아 저장
 */
public class Main {

    static String[] st;
    static int[] costs;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 구매하려는 카드 수

        st = br.readLine().split(" ");
        costs = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            costs[i] = Integer.parseInt(st[i - 1]);
            dp[i] = 10000000;
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j] + costs[j]);
            }
        }
        System.out.println(dp[n]);
    }
}