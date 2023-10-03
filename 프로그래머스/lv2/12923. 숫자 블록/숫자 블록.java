import java.util.*;

class Solution {
    public long[] solution(long begin, long end) {
        long[] answer = new long[(int) (end - begin + 1)];
        
        int idx = 0;
        for (int i = (int) begin; i <= end; i++) {
            int a = evaluateProperDivisor(i);
            answer[idx++] = a;
        }
        
        return answer;
    }
    
    private int evaluateProperDivisor(int value) {
        if (value == 1) {
            return 0;
        }

        List<Integer> L = new ArrayList<>();

        for (int i = 2; i * i <= value; i++) {
            if (value % i == 0) {
                L.add(i);
                if (value / i <= 10_000_000) {
                    return value / i;
                }
            }
        }
        
        if (!L.isEmpty()) {
            return L.get(L.size() - 1);
        }

        return 1;
    }
}