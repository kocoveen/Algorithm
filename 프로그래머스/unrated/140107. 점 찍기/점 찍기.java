class Solution {
    public long solution(long k, long d) {
        long answer = 0;
        
        for (long i = 0; i <= d; i += k) {
            answer += (long) Math.sqrt(d * d - i * i) / k + 1l;
            // for (int j = 0; j * j <= d * d - i * i; j += k) {
            //     answer++;
            // }
        }
        
        return answer;
    }
}