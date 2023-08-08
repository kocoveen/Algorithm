import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int l = elements.length;
        
        Set<Integer> S = new HashSet<>();
        for (int i = 0; i < l; i++) {
            int init = elements[i];
            S.add(init);
            for (int j = 1; j < l; j++) {
                init += elements[(i + j) % l];
                S.add(init);
            }  
        }
        
        return S.size();
    }
}