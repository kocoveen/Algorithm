class Solution {
    public static final int C = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] route = new int[m + 1][n + 1];
        
        for (int[] puddle : puddles) {
            route[puddle[0]][puddle[1]] = -1;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                
                if (i == 1 && j == 1) {
                    route[i][j] = 1;
                    continue;
                }
                
                if (route[i][j] < 0) {
                    continue;
                }
                
                if (route[i - 1][j] == -1) {
                    route[i][j] = route[i][j - 1];
                } else if (route[i][j - 1] == -1) {
                    route[i][j] = route[i - 1][j];
                } else {
                    route[i][j] = (route[i - 1][j] % C + route[i][j - 1] % C) % C;
                }
            }
        }
                
        return route[m][n];
    }
    
    private void print(int[][] route) {
        for (int[] r : route) {
            for (int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}