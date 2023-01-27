import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 0;
        
        for (int i = 0; i < before.length(); i++) {
            after = after.replaceFirst(before.substring(i, i+1), "");
        }
        
        if (after.equals("")) {
            answer = 1;
        }
        
        return answer;
        
    }
}