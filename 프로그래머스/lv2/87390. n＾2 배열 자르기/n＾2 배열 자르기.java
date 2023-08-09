class Solution {
    public long[] solution(int n, long left, long right) {
        int len = (int) (right - left) + 1;
        long[] answer = new long[len];
        
        long i = left; int j = 0;
        while (i <= right) {
            long row = i / n;
            long col = i % n;
            
            if (row < col) {
                answer[j] = col + 1;
            } else {
                answer[j] = row + 1;
            }
            i++;
            j++;
        }
        
        return answer;
    }
}