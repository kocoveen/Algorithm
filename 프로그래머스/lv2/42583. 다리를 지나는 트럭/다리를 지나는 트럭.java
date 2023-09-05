import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, truckCount = 0, curWeight = 0;
        
        Queue<Integer> waiting = new LinkedList();
        Queue<Integer> bridge = new LinkedList();
        Queue<Integer> arrived = new LinkedList();
        
        for (int i : truck_weights) {
            waiting.add(i);
        }
        
        while (arrived.size() != truck_weights.length) {
            answer++;
            if (!bridge.isEmpty() && bridge.size() >= bridge_length) {
                int t = bridge.remove();
                if (t > 0) {
                    arrived.add(t);
                    curWeight -= t;
                }
            }
            
            if (!waiting.isEmpty() && weight >= curWeight + waiting.peek()) {
                int t = waiting.remove();
                bridge.add(t);
                curWeight += t;
            } else {
                bridge.add(0);
            }
            
        }
        
        
        return answer;
    }
}