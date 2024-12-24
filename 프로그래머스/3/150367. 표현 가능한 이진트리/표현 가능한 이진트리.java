class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        int idx = 0;
        
        for (long number: numbers) {
            String str = Long.toBinaryString(number);
            
            int zeroLength = nextPowerOfTwo(str.length()) - str.length();
            str = "0".repeat(zeroLength) + str;
            if (str.length() % 2 != 1) str = "0" + str;
            
            // System.out.println(str);
            answer[idx++] = isExpressible(str) ? 1 : 0;
        }
        return answer;
    }
    
    private boolean isExpressible(String str) {
        // str의 길이가 (2의 거듭제곱 - 1)이 아니면
        // = 포화 이진트리가 아니면
        if (str.length() <= 1) return true;
        
        int cIdx = str.length() / 2;                // 중앙 인덱스
        int lIdx = cIdx / 2;                  // 왼쪽 자식 인덱스
        int rIdx = (cIdx + 1 + str.length()) / 2;   // 오른쪽 자식 인덱스
        
        if (str.charAt(cIdx) == '0' && (str.charAt(lIdx) == '1' || str.charAt(rIdx) == '1')) return false;

        return isExpressible(str.substring(0, cIdx)) && 
            isExpressible(str.substring(cIdx + 1, str.length()));
    }
    
    public static int nextPowerOfTwo(int n) {
        if (n <= 0) { return 1; }
        int m = 1;
        while (m <= n && m < 64) { m <<= 1; }
        return m - 1;
    }
}