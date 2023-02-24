public class Solution {
    public String solution(String s) {
        String answer = "";
        char[] sBits = s.toCharArray();
        
        int tokenLength = 0;
        for(int i = 0; i < sBits.length; i++) {

            if (sBits[i] == ' ') {
                tokenLength = 0;
                continue;
            }

            if (tokenLength % 2 == 0 && ('a' <= sBits[i] && sBits[i] <= 'z')) {
                sBits[i] -= 32;
            }
            
            if (tokenLength % 2 != 0 && ('A' <= sBits[i] && sBits[i] <= 'Z')) {
                sBits[i] += 32;
            }
            tokenLength++;
        }
        
        return String.valueOf(sBits);
    }
}