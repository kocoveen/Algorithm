import module java.base;

class Solution {
    
    List<Integer>[] graph;
    int[][] dp;
    boolean[] visit;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] light : lighthouse) {
            int u = light[0];
            int v = light[1];
            
            graph[u].add(v);
            graph[v].add(u);
        }
        
        dp = new int[n+1][2]; // [][0] : 안 킴, [][1] : 킴
        visit = new boolean[n+1];
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int node) {
        visit[node] = true;
        dp[node][0] = 0; // node를 안 킨 경우
        dp[node][1] = 1; // node를 킨 경우
        
        for (int i : graph[node]) {
            if (visit[i]) continue;
            dfs(i);
            dp[node][0] += dp[i][1];
            dp[node][1] += Math.min(dp[i][0], dp[i][1]);
        }
    }
}