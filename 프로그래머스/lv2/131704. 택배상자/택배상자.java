import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> S = new Stack<>();
        for (int i = 1, idx = 0; i <= order.length; i++) {
            S.push(i);
            while (!S.isEmpty() && S.peek() == order[idx]) {
                S.pop();
                idx++;
                answer++;
            }
        }
        
        return answer;
    }
}