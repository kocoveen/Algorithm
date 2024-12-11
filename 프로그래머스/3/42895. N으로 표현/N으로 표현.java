import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = -1;
        
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        dp[1].add(N);
        
        for (int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                
                
                for (int a : dp[i-j]) {
                    for (int b : dp[j]) {
                        dp[i].add(a + b);
                        dp[i].add(a * b);
                        
                        
                        if (a > b) dp[i].add(a - b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
                dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));
            }
        }
        
        for (int i = 1; i <= 8; i++) {
            System.out.println(dp[i]);
            if (dp[i].contains(number)) {
                return i;
            }
        }
        
        return answer;
    }
}