class Solution {
    public static final int C = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] route = new int[m + 1][n + 1];
        
        for (int[] puddle : puddles) {
            route[puddle[0]][puddle[1]] = -1;
        }
        
        route[1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(route[i][j] == -1){
                    route[i][j] = 0;
                    continue;
                }
                if(i != 1) route[i][j] += route[i - 1][j] % C;
                if(j != 1) route[i][j] += route[i][j - 1] % C;
            }
        }
                
        return route[m][n] % C;
    }
}