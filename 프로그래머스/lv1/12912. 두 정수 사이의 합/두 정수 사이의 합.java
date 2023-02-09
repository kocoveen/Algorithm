class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        long k = Math.min(a, b);
        long l = Math.max(a, b);
        
        answer = (l - k + 1) * (k + l) / 2;
        
        return answer;
    }
}