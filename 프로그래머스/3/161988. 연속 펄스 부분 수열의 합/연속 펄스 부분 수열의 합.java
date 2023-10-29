class Solution {
    public long solution(int[] sequence) {
        int a = 1, b = -1, len = sequence.length;
        long aSum = sequence[0], bSum = sequence[0] * -1, aMin = 0, bMin = 0, max = Long.MIN_VALUE;
        
        // aSum : 인덱스가 i 일때, 1로 시작하는 펄스 수열과 sequence 누적합
        // bSum : 인덱스가 i 일때, -1로 시작하는 펄스 수열과 sequence 누적합
        // aMin : aSum의 가장 작은 값
        // bMin : bSum의 가장 작은 값
        for (int i = 1; i <= len; i++) {
            a *= -1;
            b *= -1;
            
            max = Math.max(max, aSum - aMin);
            max = Math.max(max, bSum - bMin);
            
            aMin = Math.min(aMin, aSum);
            bMin = Math.min(bMin, bSum);
            
            if (i == len) break;
            
            aSum += sequence[i] * a;
            bSum += sequence[i] * b;
        }
        
        return max;
    }
}