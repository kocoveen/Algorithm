import java.util.*;

public class Main {
    static int C, N;
    static int[][] cities;
    static Integer[] dp;
    static final int INF = 987654321;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        C = sc.nextInt();
        N = sc.nextInt();
        cities = new int[N][2];

        for (int i = 0; i < N; i++) {
            cities[i][0] = sc.nextInt(); // 비용
            cities[i][1] = sc.nextInt(); // 고객 수
        }

        // 필요한 고객 수만큼 메모이제이션 배열 선언
        dp = new Integer[C + 1];
        
        System.out.println(dp(C));
    }

    private static int dp(int remain) {
        // [기저 사례] 목표 인원을 모두 채운 경우
        if (remain <= 0) {
            return 0;
        }

        // [메모이제이션] 이미 계산한 적이 있는 경우
        if (dp[remain] != null) {
            return dp[remain];
        }

        int minCost = INF;

        for (int i = 0; i < N; i++) {
            int cost = cities[i][0];
            int customers = cities[i][1];
            // 현재 도시에서 홍보를 한 번 할 때의 비용 + 남은 인원을 채우는 최소 비용
            // 남은 인원이 음수가 되더라도 기저 사례에서 0을 반환하므로 안전합니다.
            minCost = Math.min(minCost, dp(remain - customers) + cost);
        }
        return dp[remain] = minCost;
    }
}