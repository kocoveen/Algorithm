class Solution {
    Integer[][] dp;
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int maxLen = triangle.length;

        dp = new Integer[maxLen][];
        
        for (int i = 0; i < maxLen; i++) {
            dp[i] = new Integer[i + 1];
        }
        
        for (int i = 0; i < maxLen; i++) {
            dp[maxLen - 1][i] = triangle[maxLen - 1][i];
        }
        
        answer = func(0, 0, triangle);
        
        return answer;
    }
    
    private int func(int i, int j, int[][] triangle) {
        if (dp[i][j] == null) {
            dp[i][j] = triangle[i][j] + Math.max(func(i + 1, j, triangle), func(i + 1, j + 1, triangle));
        }
        return dp[i][j];
    }
}