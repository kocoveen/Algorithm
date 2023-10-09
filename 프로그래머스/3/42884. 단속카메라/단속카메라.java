import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));
        
        int camera = Integer.MIN_VALUE;
        
        for (int[] a : routes) {
            if (camera < a[0]) {
                answer++;
                camera = a[1];
            }
        }
        return answer;
    }
}