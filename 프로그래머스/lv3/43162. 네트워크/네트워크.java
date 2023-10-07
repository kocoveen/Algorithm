import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[computers.length];
        
        Queue<Integer> Q = new LinkedList<>();
        
        for (int c = 0; c < computers.length; c++) {
            if (visited[c]) continue;
            answer++;
            
            Q.add(c);
            visited[c] = true;
            while (!Q.isEmpty()) {
                Integer cur = Q.remove();
                for (int i = 0; i < computers.length; i++) {
                    if (visited[i]) continue;
                    if (computers[cur][i] == 0) continue;

                    Q.add(i);
                    visited[i] = true;
                }
            }
        }

        
        return answer;
    }
}