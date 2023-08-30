import java.util.*;

class Solution {
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int n, m;
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int[][] board = new int[n][m];
        Queue<Pair> Q = new LinkedList<>();
        
        Q.add(new Pair(0, 0));
        visited[0][0] = true;
        board[0][0] = 1;
        
        while (!Q.isEmpty()) {
            Pair p = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (isNotBoundaryIn(nr, nc)) continue;
                if (maps[nr][nc] == 0 || visited[nr][nc]) continue;
                if (nr == n && nc == m) {
                    return board[p.r][p.c] + 1;
                }
                visited[nr][nc] = true;
                board[nr][nc] = board[p.r][p.c] + 1;
                Q.add(new Pair(nr, nc));
            }
        }
        
        // for (int[] i : board) {
        //     for (int j : i) {
        //         System.out.printf("%d ", j);
        //     }
        //     System.out.println();
        // }
        
        int answer = board[n - 1][m - 1];
        return answer == 0 ? -1 : answer;
    }
    
    private static boolean isNotBoundaryIn(int nr, int nc) {
        return nr >= n || nc >= m || nr < 0 || nc < 0; 
    }
    
    private static class Pair {
        int r;
        int c;
        
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}