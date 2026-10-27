import java.util.*;

class Solution {
    
    static int[][] oiles; // 0: 시추 X; > 0: 시추 지역번호
    static int N;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static Queue<Pair> q = new ArrayDeque<>();
    static int H, W;
    static int[] count;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        int maxOil = 0;
        H = land.length;
        W = land[0].length;
        count = new int[H * W];
        oiles = new int[H][W];
        
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (land[r][c] == 1 && oiles[r][c] == 0) {
                    N++;
                    drill(r, c, land);
                }
            }
        }
        
        for (int r = 0; r < H; r++) {
            for (int c = 0; c < W; c++) {
                if (oiles[r][c] > 0) {
                    count[oiles[r][c]]++;
                }
            }
        }
        
        
        for (int c = 0; c < W; c++) {
            Set<Integer> set = new HashSet<>();
            for (int r = 0; r < H; r++) {
                if (oiles[r][c] > 0) {
                    set.add(oiles[r][c]);
                }
            }
            
            int total = 0;
            for (int elem : set) {
                total += count[elem];
            }
            answer = Math.max(answer, total);
        }
        
        return answer;
    }
    
    private void drill(int r, int c, int[][] land) {
        q.add(new Pair(r, c));
        oiles[r][c] = N;
        while (!q.isEmpty()) {
            Pair p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = p.r() + dr[i];
                int nc = p.c() + dc[i];
                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (land[nr][nc] == 0) continue;
                if (oiles[nr][nc] > 0) continue;
                q.add(new Pair(nr, nc));
                oiles[nr][nc] = N;
            }
        }  
    }
}

record Pair(int r, int c) {}