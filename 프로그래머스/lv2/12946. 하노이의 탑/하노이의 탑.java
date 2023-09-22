import java.util.*;

class Solution {
    int[][] answer;
    int idx;
    int size;
    
    public int[][] solution(int n) {
        idx = 0;
        size = (int) Math.pow(2, n) - 1;
        answer = new int[size][2];
        
        hanoi(1, 3, 2, n);
        return answer;
    }
    
    private void hanoi(int from, int to, int tmp, int size) {
        if (size == 1) {
            answer[idx++] = new int[]{from, to};
            return;
        }
        
        hanoi(from, tmp, to, size - 1);
        answer[idx++] = new int[]{from, to};
        hanoi(tmp, to, from, size - 1);
    }
}