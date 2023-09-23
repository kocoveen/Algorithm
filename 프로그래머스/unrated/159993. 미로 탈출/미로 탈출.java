import java.util.*;

class Solution {
    boolean[][] visited;
    int[][] board;
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(String[] maps) {
        int answer = 0;
        
        int row = maps.length;
        int col = maps[0].length();
        
        boolean open = false;
        
        Queue<Pair> Q = new LinkedList<>();
        Pair[] special = new Pair[2];
        
        visited = new boolean[row][col];
        board = new int[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                
                char tile = maps[i].charAt(j);
                
                if (tile == 'X') {
                    board[i][j] = -1;
                } else if (tile == 'L') {
                    special[0] = new Pair(i, j);
                } else if (tile == 'E') {
                    special[1] = new Pair(i, j);
                } else if (tile == 'S') {
                    Q.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= row || nc >= col) continue;
                if (board[nr][nc] == -1) continue;
                if (visited[nr][nc]) continue;
                
                Q.add(new Pair(nr, nc));
                visited[nr][nc] = true;
                board[nr][nc] = board[cur.r][cur.c] + 1;
                
                if (open && nr == special[1].r && nc == special[1].c) {
                    
                    // printBoard(board);
                    
                    return board[cur.r][cur.c] + 1;    
                }
                
                if (!open && nr == special[0].r && nc == special[0].c) {
                    open = true;
                    visited = new boolean[row][col];
                    Q = new LinkedList<>();
                    
                    Q.add(new Pair(nr, nc));
                    visited[nr][nc] = true;
                    board[nr][nc] = board[cur.r][cur.c] + 1;
                    
                    break;
                }
            }
        }
        
        // printBoard(board);
        
        if (!open || board[special[1].r][special[1].c] == 0) {
            return -1;
        }
        
        return board[special[1].r][special[1].c];
    }
    
    static class Pair {
        int r;
        int c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    private void printBoard(int[][] board) {
        for (int[] b : board) {
            for (int i : b) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }
    }
}