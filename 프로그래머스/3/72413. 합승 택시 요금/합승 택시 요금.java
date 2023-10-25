class Solution {
    
    public static final int INF = Integer.MAX_VALUE / 10;
    int[][] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = INF;
                } else {
                    graph[i][j] = 0;
                }
            } 
        }
        
        for (int i = 0; i < fares.length; i++) {
            int c = fares[i][0];
            int d = fares[i][1];
            int f = fares[i][2];
            graph[c][d] = f;
            graph[d][c] = f;
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
        
        int answer = graph[s][a] + graph[s][b];
        
        for (int i = 1; i <= n; i++) {
            if (i == s) continue;
            answer = Math.min(graph[s][i] + graph[i][a] + graph[i][b], answer);
        }
        
        return answer;
    }
}