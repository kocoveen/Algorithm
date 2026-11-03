import java.util.*;

class Solution {
    boolean[][] visited;
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    Queue<Point> q = new ArrayDeque<>();
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                
                int color = picture[i][j];
                int size = bfs(i, j, m, n, picture);
                
                if (color != 0) {
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                    numberOfArea++;
                }
            }
        }
        
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
    
    private int bfs(int r, int c, int m, int n, int[][] picture) {
        int area = 0;
        int color = picture[r][c];
        q.add(new Point(r, c));
        while (!q.isEmpty()) {
            Point p = q.remove();
            
            for (int i = 0; i < 4; i++) {
                int nr = p.r() + dr[i];
                int nc = p.c() + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                if (picture[nr][nc] != color) continue;
                if (visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new Point(nr, nc));
                area++;
            }
        }
        return area;
    }
}

record Point(int r, int c) {}