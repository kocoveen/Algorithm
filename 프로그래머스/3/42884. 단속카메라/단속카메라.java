import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (r1, r2) -> r1[0] - r2[0]);
        
        int[] camera = routes[0];
        
        for (int[] route : routes) {
            if (route[0] <= camera[1]) {
                camera[1] = Math.min(route[1], camera[1]);
            } else {
                camera = route;
                answer++;
            }
        }
        
        return answer + 1;
    }
}