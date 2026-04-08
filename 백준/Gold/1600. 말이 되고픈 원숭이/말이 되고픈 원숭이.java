import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력을 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        if (W == 1 && H == 1) {
            System.out.println(0);
            return;
        }

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                if (st.nextToken().charAt(0) == '1') map[i][j] = 1;
            }
        }

        // 메모리 절약을 위해 boolean 3차원 배열 (H, W 순서가 성능상 유리)
        boolean[][][] visited = new boolean[K + 1][H][W];
        
        // 객체 생성 없이 int 값만 담는 큐
        // 데이터 구조: (k << 16) | (r << 8) | c
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0); 
        visited[0][0][0] = true;

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        int[] dhr = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dhc = {-1, 1, -2, 2, -2, 2, -1, 1};

        int moveCount = 0;
        while (!q.isEmpty()) {
            moveCount++;
            int size = q.size();
            
            // 현재 레벨(이동 횟수)만큼 반복
            while (size-- > 0) {
                int curr = q.poll();
                int ck = (curr >> 16) & 0xFF;
                int cr = (curr >> 8) & 0xFF;
                int cc = curr & 0xFF;

                // 1. 일반 보행 (4방향)
                for (int i = 0; i < 4; i++) {
                    int nr = cr + dr[i];
                    int nc = cc + dc[i];
                    if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[ck][nr][nc]) {
                        if (nr == H - 1 && nc == W - 1) {
                            System.out.println(moveCount);
                            return;
                        }
                        visited[ck][nr][nc] = true;
                        q.offer((ck << 16) | (nr << 8) | nc);
                    }
                }

                // 2. 말 점프 (8방향) - K 횟수가 남았을 때만
                if (ck < K) {
                    int nk = ck + 1;
                    for (int i = 0; i < 8; i++) {
                        int nr = cr + dhr[i];
                        int nc = cc + dhc[i];
                        if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] == 0 && !visited[nk][nr][nc]) {
                            if (nr == H - 1 && nc == W - 1) {
                                System.out.println(moveCount);
                                return;
                            }
                            visited[nk][nr][nc] = true;
                            q.offer((nk << 16) | (nr << 8) | nc);
                        }
                    }
                }
            }
        }

        System.out.println(-1);
    }
}