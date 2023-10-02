import java.util.*;

class Solution {

    public double[] solution(int k, int[][] ranges) {
        List<Double> L = new ArrayList<>();
        L.add(0.0);
        double[] answer = new double[ranges.length];
        
        int x = 0;
        int y = k;
        while (y > 1) {
            int nx = x + 1;
            int ny;
            
            if (y % 2 == 0) {
                ny = y / 2;
            } else {
                ny = y * 3 + 1;
            }
            double S = (ny + y) / 2.0;
            L.add(S + L.get(x));
            x = nx;
            y = ny;
        }
        
        // for (double d : L) {
        //     System.out.println(d);
        // }
        
        int n = L.size() - 1;
        for (int r = 0; r < ranges.length; r++) {
            int a = ranges[r][0];
            int b = n + ranges[r][1];
            double R;
            
            // if (a > n || a < 0 || b > n || b < 0) {
            //     R = 0.0;
            // } 
            
            
            if (a > b) {
                R = -1.0;
            } else {
                R = L.get(n + ranges[r][1]) - L.get(ranges[r][0]);
            }

            answer[r] = R;
        }
        
        return answer;
    }
    
}