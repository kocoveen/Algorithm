import java.util.Arrays;

class Solution {
    public int[] solution(int target) {
        // dp[i][0] : 최소 다트 수
        // dp[i][1] : 최대 싱글/불 횟수
        int[][] dp = new int[target + 1][2];
        
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }
        
        for (int i = 1; i <= 20; i++) {
            if (i <= target) update(dp, i, 1, 1);
        }
        if (50 <= target) update(dp, 50, 1, 1);
        
        for (int i = 1; i <= 20; i++) {
            if (i * 2 <= target) update(dp, i * 2, 1, 0);
            if (i * 3 <= target) update(dp, i * 3, 1, 0);
        }
        
        // DP 점화식 수행 (1점부터 target점까지 채워나감)
        for (int i = 1; i <= target; i++) {
            if (dp[i][0] == Integer.MAX_VALUE) continue;
            
            
            // 1. 싱글 및 불 더하기
            for (int score = 1; score <= 20; score++) {
                if (i + score <= target) {
                    update(dp, i + score, dp[i][0] + 1, dp[i][1] + 1);
                }
            }
            if (i + 50 <= target) {
                update(dp, i + 50, dp[i][0] + 1, dp[i][1] + 1);
            }
            
            // 2. 더블 및 트리플 더하기
            for (int score = 1; score <= 20; score++) {
                if (i + score * 2 <= target) {
                    update(dp, i + score * 2, dp[i][0] + 1, dp[i][1]);
                }
                if (i + score * 3 <= target) {
                    update(dp, i + score * 3, dp[i][0] + 1, dp[i][1]);
                }
            }
        }
        
        return dp[target];
    }
    
    // DP 배열을 조건(최소 다트 수 -> 최대 싱글/불 횟수)에 맞춰 갱신
    private void update(int[][] dp, int nextScore, int nextDarts, int nextSingles) {
        // 1. 더 적은 다트 수로 만들 수 있다면 무조건 갱신
        if (nextDarts < dp[nextScore][0]) {
            dp[nextScore][0] = nextDarts;
            dp[nextScore][1] = nextSingles;
        } 
        // 2. 다트 수가 같다면, 싱글/불 횟수가 더 많은 쪽으로 갱신
        else if (nextDarts == dp[nextScore][0]) {
            if (nextSingles > dp[nextScore][1]) {
                dp[nextScore][1] = nextSingles;
            }
        }
    }
}
