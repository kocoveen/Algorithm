class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        int size = dots.length-1;
        
        for (int i = 1; i < dots.length; i++) {
            double a = (double) (dots[0][1] - dots[i][1]) / (dots[0][0] - dots[i][0]);
            double b = (double) (dots[i%size+1][1] - dots[(i+1)%size+1][1]) / (dots[(i)%size+1][0] - dots[(i+1)%size+1][0]);
            System.out.printf("(0, %d), (%d, %d) : %f, %f\n", i, i%size+1, (i+1)%size+1, a, b);
        
            if(a == b) {
                answer = 1;
            }
        }
        
        return answer;
    }
}