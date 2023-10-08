class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        int elem = s / n;
        int reminder = s % n;
        
        if (elem == 0) {
            return new int[]{-1};
        }
        
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = elem;
            if (reminder > 0) {
                answer[i]++;
                reminder--;
            }
        }
        
        return answer;
    }
}