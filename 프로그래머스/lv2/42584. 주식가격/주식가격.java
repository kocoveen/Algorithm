import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        Stack<Integer> S = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            
            while (!S.isEmpty() && prices[S.peek()] > prices[i]) {
                int idx = S.pop();
                answer[idx] = i - idx;
            }
            S.push(i);
        }
        
        while (!S.isEmpty()) {
            int leftIdx = S.pop();
            answer[leftIdx] = prices.length - leftIdx - 1;
        }
        
        return answer;
    }
}