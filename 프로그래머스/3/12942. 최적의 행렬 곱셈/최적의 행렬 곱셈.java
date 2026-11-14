class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        
        int size = matrix_sizes.length;
        
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == j) dp[i][j] = 0;
            }
        }
        
        for (int i = 1; i < size; i++) { // 차이
            for (int s = 0; s < size-i; s++) {
                int e = s+i;
                
                for (int k = s; k < e; k++) {
                    int cost = dp[s][k] + dp[k+1][e]
                        + (matrix_sizes[s][0] * matrix_sizes[k][1] * matrix_sizes[e][1]);
                    
                    dp[s][e] = Math.min(dp[s][e], cost);
                }
            }
        }
        
        return dp[0][size-1];
    }
}