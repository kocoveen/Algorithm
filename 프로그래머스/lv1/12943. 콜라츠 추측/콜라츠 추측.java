class Solution {
    public int solution(long num) {
        int answer = 0;
        while (answer <= 501) {
            if (num == 1) return answer;
            if (answer > 500) return -1;
            
            answer += 1;
            
            num = (num % 2 == 0) ? (num / 2) : (num * 3 + 1);
        }
        
        return answer;
    }
}