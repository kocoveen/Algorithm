import java.util.*;
/**
 * dp의 row는 
 *     {
 *       {money[0]} 가 포함된 경우의 수,
 *       {money[0], money[1]} 가 포함된 경우의 수,
 *       {money[0], money[1], money[2]} 가 포함된 경우의 수,
 *       ...,
 *       {money[0], money[1], ..., money[len - 1]} 가 포함된 경우의 수
 *     }
 * dp의 col은 col과 같은 수를 만들 경우의 수
 */
class Solution {
    
    public int solution(int n, int[] money) {
        int answer = 0;
        int len = money.length;
        
        Arrays.sort(money);
        int[][] dp = new int[len + 1][n + 1];
        for (int i = 0; i <= len; i++) { // 0을 만드는 경우의 수는 1로 만들어 줌
            dp[i][0] = 1;
        }
        
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >= money[i-1]) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-money[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        
        return dp[len][n];
    }
}