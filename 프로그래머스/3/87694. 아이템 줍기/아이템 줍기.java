import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public int solution(int[][] rectangle, int characterC, int characterR, int itemC, int itemR) {
        int[][] map = new int[102][102];
        
        for (int[] rect : rectangle) {
            int c1 = rect[0] * 2;
            int r1 = rect[1] * 2;
            int c2 = rect[2] * 2;
            int r2 = rect[3] * 2;
            
            for (int i = r1; i <= r2; i++) {
                for (int j = c1; j <= c2; j++) {
                    if (i > r1 && i < r2 && j > c1 && j < c2) {
                        map[i][j] = -1;
                    } 
                    else if (map[i][j] != -1) {
                        map[i][j] = 1;
                    }
                }
            }
        }
        
        // for (int i = 0; i < map.length; i++) {
        //     for (int j = 0; j < map.length; j++) {
        //         char c = switch (map[i][j]) {
        //             case -1 -> '.';
        //             case  1 -> '@';
        //             default -> '#';
        //         };
        //         IO.print(c);
        //     }
        //     IO.println();
        // }
        
        
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(characterR * 2, characterC * 2, 0));
        map[characterR * 2][characterC * 2] = 0;
        
        while (!q.isEmpty()) {
            Point p = q.remove();
            
            if (p.r() == itemR * 2 && p.c() == itemC * 2) {
                return p.d() / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nr = p.r() + dr[i];
                int nc = p.c() + dc[i];
                
                if (nr < 0 || nr >= 102 || nc < 0 || nc >= 102) continue;
                if (map[nr][nc] != 1) continue;
                
                map[nr][nc] = 0;
                q.add(new Point(nr, nc, p.d() + 1));
            }
        }
        return 0;
    }
}

record Point(int r, int c, int d) {}
