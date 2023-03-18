import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> hof = new ArrayList<>();
        
        for (int i = 0; i < score.length; i++) {
            hof.add(Integer.valueOf(score[i]));
            
            if(i > 0) {
                Collections.sort(hof);
            }
            
            if(hof.size() > k) {
                hof.remove(0);
            }
                        
            answer[i] = hof.get(0).intValue();
        }
        
        
        
        return answer;
    }
}