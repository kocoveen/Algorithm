class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int cnt = 0;
        
        for (int i = 1; i <= number; i++) {
            cnt = 0;
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    cnt = (i / j == j) ? ++cnt : cnt + 2;
                }
            }            
            if (cnt > limit) {
                answer += power;
                continue;
            }
            answer += cnt;
        }
        return answer;
    }
}