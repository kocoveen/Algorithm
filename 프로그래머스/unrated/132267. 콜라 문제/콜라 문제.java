class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int cola = n;
        int quotient = 0;
        int remainder = 0;
        
        while(true) {
            quotient = (int) cola / a;
            remainder = cola % a;
            
            answer += quotient * b;
            cola = quotient * b + remainder;
            
            if(quotient == 0) {
                break;
            }
        }
        
        return answer;
    }
}