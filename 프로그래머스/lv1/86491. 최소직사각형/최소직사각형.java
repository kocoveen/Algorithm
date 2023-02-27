class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxX = 0;
        int maxY = 0;

        for (int[] size : sizes) {
            if (size[0] < size[1]) {
                size[0] = size[0] + size[1];
                size[1] = size[0] - size[1];
                size[0] = size[0] - size[1];
            }
        }
        
        for (int[] size : sizes) {
            if (maxX < size[0])
                maxX = size[0];
            
            if (maxY < size[1])
                maxY = size[1];
        }
        
        return maxX * maxY;
    }
}