class Solution {
    public int[] solution(long n) {
        int l = String.valueOf(n).length();
        int[] answer = new int[l];
        
        for (int i = 0; i < l; i++) {
            answer[i] = (int) (n % 10);
            n /= 10;
        }
        
        return answer;
    }
}