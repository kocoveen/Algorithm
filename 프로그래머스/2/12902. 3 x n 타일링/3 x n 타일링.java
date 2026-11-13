class Solution {
    public int solution(int n) {
        // n이 홀수이면 타일을 채울 수 없음
        if (n % 2 == 1) {
            return 0;
        }
        
        int mod = 1_000_000_007;
        long[] dp = new long[n+1];
        
        dp[0] = 1;
        if (n >= 2) {
            dp[2] = 3;
        }
        
        for (int i = 4; i <= n; i += 2) {
            dp[i] = (4 * dp[i-2] % mod - dp[i-4] + mod) % mod;
        }
        
        return (int) dp[n];
    }
}