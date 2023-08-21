import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String a = makeBaseNumber(n, k);
        String[] bits = a.split("0+");
        
        System.out.println(makeBaseNumber(3, 3));
        
        for (String bit : bits) {
            if (isPrime(bit)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private String makeBaseNumber (int number, int base) {
        StringBuilder sb = new StringBuilder();
        while (number != 0) {
            int reminder = number % base;
            number /= base;
            sb.insert(0, reminder);
        }
        return sb.toString();
    }
    
    private boolean isPrime (String bit) {
        long number = Long.parseLong(bit);
        if (number == 1) return false;
        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}