import java.lang.Math;

class Solution {
    public int solution(int n) {
        int sum = 0;
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if(i != n/i) {
                    sum += i + n/i;
                } else {
                    sum += n/i;
                }
            }
        }
        return sum;
    }
}