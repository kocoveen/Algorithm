class Solution {
    
    public static final int INF = Integer.MAX_VALUE / 10;
    int[][] graph;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new int[n + 1][n + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = INF;
            }
            graph[i][i] = 0;
        } 
        
        for (int[] fare : fares) {
            graph[fare[0]][fare[1]] = graph[fare[1]][fare[0]] = fare[2];
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
            answer = Math.min(graph[s][i] + graph[i][a] + graph[i][b], answer);
        }
        
        return answer;
    }
}