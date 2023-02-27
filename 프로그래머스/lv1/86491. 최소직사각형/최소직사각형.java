class Solution {
    public int solution(int[][] sizes) {
        int x = 0, y = 0;
        
        for (int[] size : sizes) {
            x = Math.max(x, Math.max(size[0], size[1]));
            y = Math.max(y, Math.min(size[0], size[1]));
        }
        
        int answer = x * y;
        
        return answer;
    }
}