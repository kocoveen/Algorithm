import java.util.*;

class Solution {
    
    static final int MAX = 100 * 1000 + 1;
    
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        t1 = t1 + 10; t2 = t2 + 10; int t = temperature + 10;
        
        int[][] DP = new int[onboard.length][51];
        
        for(int i = 0; i < onboard.length; i++) Arrays.fill(DP[i], MAX);
        
        DP[0][t] = 0;
        
        for (int i = 0; i < onboard.length - 1; i++){
            for (int j = 0; j <= 50; j++){
                if (onboard[i] == 1 && (j < t1 || t2 < j)) continue;

            // 에어컨 킴
                DP[i+1][j] = Math.min(DP[i+1][j], DP[i][j] + b); // 온도 유지
                if (j >= 1) DP[i+1][j-1] = Math.min(DP[i+1][j-1], DP[i][j] + a); // 온도 내림
                if (j < 50) DP[i+1][j+1] = Math.min(DP[i+1][j+1], DP[i][j] + a); // 온도 올림
                
            // 에어컨 끔
                if (t == j) DP[i+1][j] = Math.min(DP[i+1][j], DP[i][j]); // 온도 유지 
                else if (t > j && j < 50) DP[i+1][j+1] = Math.min(DP[i+1][j+1], DP[i][j]); // 온도 올림
                else if(t < j && j >= 1) DP[i+1][j-1] = Math.min(DP[i+1][j-1], DP[i][j]); // 온도 내림
            }
        }
        
        int min = MAX;
        int last = onboard.length - 1;
        
        for(int i = 0; i <= 50; i++) {
            if (onboard[last] == 1 && (i < t1 || t2 < i)) continue; // 마지막에 승객이 탑승했다면 적정 온도만 가능 
            min = Math.min(min, DP[last][i]);
        }
        return min;
    }
}