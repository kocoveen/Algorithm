import java.util.*;

class Solution {
   
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Integer[] location = new Integer[10000005];

        Queue<Integer> Q = new LinkedList<>();
        location[x] = 0;
        Q.add(x);
        
        while (!Q.isEmpty() && location[y] == null) {
            int cur = Q.remove();
            for (int nx : new int[]{cur + n, cur * 2, cur * 3}) {
                if (nx > y) continue;
                if (location[nx] != null) continue;
                location[nx] = location[cur] + 1;
                Q.add(nx);
            }
        }
        if (location[y] == null)
            return -1;
        return location[y];
    }
}