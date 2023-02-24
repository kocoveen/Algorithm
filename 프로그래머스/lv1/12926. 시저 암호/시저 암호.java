class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] sBits = s.toCharArray();
        
        for (int i = 0; i < sBits.length; i++) {
            if (sBits[i] == 32) continue;
            
            if (65 <= sBits[i] && sBits[i] <= 90) {
                if (sBits[i] + n > 90) sBits[i] = (char) (sBits[i] - 26 + n);
                else sBits[i] += n;
            }
            
            if (97 <= sBits[i] && sBits[i] <= 122) {
                if (sBits[i] + n > 122) sBits[i] = (char) (sBits[i] - 26 + n);
                else sBits[i] += n;
            }
        }
        return String.valueOf(sBits);
    }
}