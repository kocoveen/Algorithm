import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (r1, r2) -> {
            if (r1[col - 1] == r2[col - 1]) {
                return r2[0] - r1[0];
            }
            return r1[col - 1] - r2[col - 1];
        });
        
        for (int i = row_begin - 1; i < row_end; i++) {
            int S_i = 0;
            for (int idx = 0; idx < data[i].length; idx++) {
                S_i += data[i][idx] % (i + 1);
            }
            // System.out.println(S_i);
            answer = answer ^ (S_i);
            
        }
        
        return answer;
    }
}