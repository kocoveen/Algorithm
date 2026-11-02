class Solution {
    
    private static int INF = Integer.MAX_VALUE;
    int[][] dp; // row : 훔친 물건, col : b의 흔적, dp[i][j] = a의 흔적
    
    public int solution(int[][] info, int n, int m) {
        int answer = INF;
        dp = new int[info.length + 1][121];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 121; j++) {
                dp[i][j] = INF;
            }
        }
        
        dp[0][0] = 0;
        
        for (int i = 0; i < dp.length-1; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == INF) continue;
                // A가 번째 물건을 훔침.
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j] + info[i][0]);
                    
                // B가 번째 물건을 훔침.
                dp[i+1][j + info[i][1]] = Math.min(dp[i+1][j + info[i][1]], dp[i][j]);
            }
        }
        
        int[] finals = dp[info.length];
        for (int f = 0; f < m; f++) {
            answer = Math.min(finals[f], answer);
        }
        if (answer >= n) {
            answer = -1;
        }
        
        return answer;
    }
    
}