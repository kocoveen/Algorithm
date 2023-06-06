import java.util.*;

class Solution {
    
    static int[] alpha = new int[26];
    static int sum;
    
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Arrays.fill(alpha, 101);
        
        for (String key : keymap) 
            for (int i = 0; i < key.length(); i++) 
                alpha[key.charAt(i) - 'A'] = Math.min(alpha[key.charAt(i) - 'A'], i + 1);
        
        
        for (int i = 0; i < targets.length; i++) {
            sum = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                int tmp = alpha[targets[i].charAt(j) - 'A'];
                if (tmp == 101) {
                    sum = -1;
                    break;
                }
                sum += tmp;
            }
            answer[i] = sum;
        }
        
        return answer;
    }
}