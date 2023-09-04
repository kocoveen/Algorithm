import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[][] types = new int[topping.length - 1][2];
        
        Set<Integer> S1 = new HashSet<>();
        Set<Integer> S2 = new HashSet<>();
        
        for (int i = 0; i < types.length; i++) {
            int opposite = types.length - i;
            
            S1.add(topping[i]);
            S2.add(topping[opposite]);
            
            types[i][0] = S1.size();
            types[opposite - 1][1] = S2.size();
        }
        
        for (int i = 0; i < types.length; i++) {
            if (types[i][0] == types[i][1]) {
                answer++;
            }
        }
        
        return answer;
    }
}