import java.lang.Math;

class Solution {
    public int solution(int[] sides) {
        int answer = 0;
        
        for (int i = Math.abs(sides[0]-sides[1])+1; i < sides[0]+sides[1]; i++) {
            answer += 1;            
        }
            
        return answer;
    }
}