import java.util.*;
import java.io.*;

public class Main {
    static int K, W, H;
    static int[][] map;
    static boolean[][][] visited;
    
    // 말의 이동 8방향 및 원숭이 이동 4방향
    static int[] dhr = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dhc = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        K = read();
        W = read();
        H = read();

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        map = new int[H][W];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                map[i][j] = read();
            }
        }

        // 방문 체크: [말 이동 횟수][세로][가로]
        visited = new boolean[K + 1][H][W];
        
        // Queue에 객체 대신 int 저장: (k << 16) | (r << 8) | c
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0); 
        visited[0][0][0] = true;

        int steps = 0;
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            
            while (size-- > 0) {
                int curr = q.poll();
                int ck = (curr >> 16) & 0xFF;
                int cr = (curr >> 8) & 0xFF;
                int cc = curr & 0xFF;

                // 1. 일반 이동 (4방향)
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];
                    
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[ck][nr][nc]) continue;
                    
                    if (nr == H - 1 && nc == W - 1) {
                        System.out.println(steps);
                        return;
                    }
                    visited[ck][nr][nc] = true;
                    q.offer((ck << 16) | (nr << 8) | nc);
                }

                // 2. 말 이동 (K 횟수 남았을 때, 8방향)
                if (ck < K) {
                    int nk = ck + 1;
                    for (int i = 0; i < 8; i++) {
                        int nr = cr + dhr[i];
                        int nc = cc + dhc[i];
                        
                        if (nr < 0 || nr >= H || nc < 0 || nc >= W || map[nr][nc] == 1 || visited[nk][nr][nc]) continue;
                        
                        if (nr == H - 1 && nc == W - 1) {
                            System.out.println(steps);
                            return;
                        }
                        visited[nk][nr][nc] = true;
                        q.offer((nk << 16) | (nr << 8) | nc);
                    }
                }
            }
        }

        System.out.println(-1);
    }

    // 빠른 입력을 위한 메서드
    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}