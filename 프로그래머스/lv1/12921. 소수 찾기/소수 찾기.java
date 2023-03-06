import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        int i = 2;
        prime[0] = false;
        prime[1] = false;
        
        for (int k = 2; k <= n; k++) {
            i = 2;
            if (prime[k] == true) {
                while(i * k <= n) {
                    prime[i * k] = false;
                    i++;
                }
            }
        }
        
        for (boolean d : prime) {
            if(d == true) answer++;
        }
        
        return answer;
    }
}