import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> L = new ArrayList<>();
        Deque<Integer> D = new ArrayDeque<>();
        
        for (int i = 0; i < speeds.length; i++) {
            int day = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            
            if (D.isEmpty() || D.getLast() >= day) {
                D.addFirst(day);
                
            } else {
                L.add(D.size());
                D.clear();
                D.addFirst(day);
            }
        }
        
        if (!D.isEmpty()) {
           L.add(D.size());
        }
        
        return L.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}