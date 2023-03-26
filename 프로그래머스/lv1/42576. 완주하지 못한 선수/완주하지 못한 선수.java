import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int pIndex = 0;
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for (int i = 0; i < participant.length - 1; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
            
            pIndex = i + 1;
        }
        return participant[pIndex];
    }
}