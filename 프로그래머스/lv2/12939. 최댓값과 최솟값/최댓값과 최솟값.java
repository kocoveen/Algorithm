import java.util.*;

class Solution {
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    
    public String solution(String s) {
        String[] tokens = s.split(" ");
        int[] nums = new int[tokens.length];
        for(int i = 0; i < tokens.length; i++) {
            int val = Integer.parseInt(tokens[i]);
            if (max < val) max = val;
            if (min > val) min = val;
        }
        
        
        return min + " " + max;
    }
}