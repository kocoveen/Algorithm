import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] bits = s.toCharArray();
        Arrays.sort(bits);
        
        answer = new StringBuilder(new String(bits)).reverse().toString();
        
        return answer;
    }
}