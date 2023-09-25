import java.util.*;

class Solution {
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    int[][] panel;
    boolean[][] visited;
    int w, h;
    
    Queue<Pair> Q = new LinkedList<>();
    Pair R, G;
    
    public int solution(String[] board) {
        h = board.length;
        w = board[0].length();
        
        panel = init(board);
        visited = new boolean[h][w];
        
        Q.add(R);
        visited[R.r][R.c] = true;
        
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int n = 0;
                int nr = cur.r;
                int nc = cur.c;
                
                while (isInBoundary(nr + dr[i], nc + dc[i]) && panel[nr + dr[i]][nc + dc[i]] != -1) {
                    nr += dr[i];
                    nc += dc[i];
                }
                
                if (visited[nr][nc]) continue;
                    
                if (panel[nr][nc] == 1) {
                    return cur.count + 1;
                }
                
                Q.add(new Pair(nr, nc, cur.count + 1));
                visited[nr][nc] = true;
            }
        }
        
        return -1;
    }
    
    private int[][] init(String[] board) {
        int[][] tmp = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                switch (board[i].charAt(j)) {
                    case 'D': tmp[i][j] = -1; break;
                    case 'G': tmp[i][j] = 1; break;
                    case 'R': R = new Pair(i, j, 0); break;
                }
            }
        }
        return tmp;
    }
    
    private boolean isInBoundary(int r, int c) {
        return r >= 0 && c >= 0 && r < h && c < w;
    }
    
    static class Pair {
        int r;
        int c;
        int count;
        
        public Pair(int r, int c, int count) {
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}