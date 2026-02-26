import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int N;
    static long K;
    static long[] sum;
    static long[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextLong();

        sum = new long[N + 1];
        dp = new long[N + 1];
        Arrays.fill(dp, -1); // 메모이제이션 초기화

        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + sc.nextLong();
        }

        System.out.println(solve(1)); // 1번 인덱스부터 시작
    }

    static long solve(int idx) {
        if (idx > N) return 0; // 나뭇가지 끝에 도달
        if (dp[idx] != -1) return dp[idx];

        // 1. 현재 먹이를 먹지 않고 다음 칸으로 이동
        long res = solve(idx + 1);

        // 2. 현재 위치(idx)부터 만족할 때까지 먹는 경우
        // S[nextIdx] >= S[idx-1] + K 인 최소 nextIdx를 이분 탐색으로 찾음
        long target = sum[idx - 1] + K;
        int nextIdx = lowerbound(idx, target);

        if (nextIdx <= N) {
            long energy = (sum[nextIdx] - sum[idx - 1]) - K;
            // nextIdx까지 먹었으므로, 그 다음 식사는 nextIdx + 1부터 가능
            res = Math.max(res, solve(nextIdx + 1) + energy);
        }

        return dp[idx] = res;
    }

    private static int lowerbound(int idx, long target) {
        int nextIdx = Arrays.binarySearch(sum, idx, N + 1, target);
        return nextIdx < 0 ? ~nextIdx : nextIdx;
    }
}