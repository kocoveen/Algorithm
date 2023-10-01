import java.util.*;
import java.util.Arrays;

class Solution {
    Integer[] visited;
    Integer[] count;
    int boxNum = 1;
    
    public int solution(int[] cards) {
        int answer = 1;
        visited = new Integer[cards.length + 1];
        
        for (int i : cards) {
            if (visited[i] != null) {
                continue;
            }
            // System.out.println();
            
            int idx = i;
            while (visited[cards[idx - 1]] == null) {
                visited[cards[idx - 1]] = boxNum;
                // System.out.println(idx);
                idx = cards[idx - 1];
            }
            boxNum++;
        }
        
        count = new Integer[boxNum]; count[0] = 0;
        for (int i = 1; i < visited.length; i++) {
            if (count[visited[i]] == null) {
                count[visited[i]] = 0;
            }
            count[visited[i]]++;
        }
        
        // for (int i = 0; i < visited.length; i++) {
        //     System.out.println(visited[i]);
        // }
        
        // for (int i = 0; i < count.length; i++) {
        //     System.out.println(count[i]);
        // }d
        
        Arrays.sort(count, (i1, i2) -> i2 - i1);
        
        answer = count[0] * count[1];

        return answer;
    }
}