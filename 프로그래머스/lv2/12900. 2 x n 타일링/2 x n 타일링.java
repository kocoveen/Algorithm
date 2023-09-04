class Solution {
    private static final int C = 1_000_000_007;
    
    public int solution(int n) {
        int[] dp = new int[60_001];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] % C + dp[i - 2] % C) % C;
        }

        return dp[n];
    }
}