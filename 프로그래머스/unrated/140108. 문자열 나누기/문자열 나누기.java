import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char basis = 0;
        char[] string = s.toCharArray();
        
        int i = 0, basisCnt = 0;
        while(i < string.length) {
            if (basisCnt == 0) {
                basis = string[i];
                answer++;
            }
            
            if(basis == string[i])
                basisCnt++;
            else
                basisCnt--;
            i++;
        }
        return answer;
        
    }
}