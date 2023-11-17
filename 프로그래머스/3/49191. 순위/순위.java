class Solution {
    public int[][] graph;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        
        graph = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j] = n;
            }
            graph[i][i] = 0;
        }
        
        for (int[] result : results) {
            graph[result[0]][result[1]] = 1; // r이 c를 이김
            graph[result[1]][result[0]] = -1; // c이 r에게 짐
        }
        
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    } else if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }        
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] >= n) {
                    answer++;
                    break;
                }
            }
        }

        return n - answer;
    }
}