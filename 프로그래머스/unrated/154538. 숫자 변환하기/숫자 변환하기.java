// import java.util.*;

// class Solution {
   
//     public int solution(int x, int y, int n) {
//         int answer = 0;
        
//         Integer[] location = new Integer[10000005];

//         Queue<Integer> Q = new LinkedList<>();
//         location[x] = 0;
//         Q.add(x);
        
//         while (!Q.isEmpty() && location[y] == null) {
//             int cur = Q.remove();
//             for (int nx : new int[]{cur + n, cur * 2, cur * 3}) {
//                 if (nx > y) continue;
//                 if (location[nx] != null) continue;
//                 location[nx] = location[cur] + 1;
//                 Q.add(nx);
//             }
//         }
//         if (location[y] == null)
//             return -1;
//         return location[y];
//     }
// }

import java.util.*;

class Solution {

    int[] dp = new int[3000003];
    int INF = 1000002;

    public int solution(int x, int y, int n) {
        int answer = 0;
        Arrays.fill(dp, INF);
        dp[x] = -1;
        dp[y] = 0;
        for(int num = Math.max(y - n, Math.max(y / 2, y / 3)); num >= x; num--){
            dp[num] = Math.min(dp[num + n] + 1, Math.min(dp[num * 2] + 1, dp[num * 3] + 1));
        }
        return dp[x] >= INF ? -1 : dp[x];
    }
}