class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int a = 1;
        
        for (int i = 2; i <= Math.min(n, m); i++) {
            while (n % i == 0 && m % i == 0) {
                a *= i;
                m /= i;
                n /= i;
            }
        }
        
        answer[0] = a;
        answer[1] = a * n * m;
        
        return answer;
    }
}