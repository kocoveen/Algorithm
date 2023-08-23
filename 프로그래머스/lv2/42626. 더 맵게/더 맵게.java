import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }
        
        while (isLessThan(pq.peek(), K)) {
            if (pq.size() == 1) return -1;
            int first = pq.remove();
            int second = pq.remove();
            
            int mixed = first + (second * 2);
            pq.add(mixed);
            answer++;
        }
        
        return answer;
    }
    
    private boolean isLessThan(int n, int K) {
        return n < K;        
    }
}