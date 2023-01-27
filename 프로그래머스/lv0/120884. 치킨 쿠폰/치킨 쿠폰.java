class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int s = 1;
        int c = chicken;
        int r = 0;
        
        while (s > 0) {
            s = c / 10;
            r = c % 10;
            c = s + r;
            
            answer += s;
        }

        return answer;
        
    }
}