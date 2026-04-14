import java.util.*;

public class Main {

    static int[][][] map;

    static class Info {
        int r, c, t;
        Info(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int[] dr = {0, 1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        map = new int[8][8][8];

        for (int i = 7; i >= 0; i--) {
            String line = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                map[i][j][0] = line.charAt(j) == '.' ? 0 : 1; 

                for (int k = i-1, l = 1; k >= 0; k--, l++) {
                    map[k][j][l] = map[k+1][j][l-1];
                }
            }
        }

        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            // 현재 '초(t)'에서 방문한 위치를 체크 (매 초마다 초기화)
            boolean[][] visited = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                Info info = q.poll();

                // 1. 8초를 버텼다면 모든 벽이 사라졌으므로 탈출 성공
                if (info.t >= 8) {
                    System.out.println(1);
                    System.exit(0);
                }

                // 2. 목적지 (7, 7) 도달 시 종료
                if (info.r == 7 && info.c == 7) {
                    System.out.println(1);
                    System.exit(0);
                }

                for (int d = 0; d < 9; d++) {
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    // 범위 체크
                    if (nr < 0 || nr > 7 || nc < 0 || nc > 7) continue;
                    
                    // 이번 초(t)에 이미 이 칸을 방문하기로 했다면 중복 큐 삽입 방지
                    if (visited[nr][nc]) continue;

                    // 이동 조건: 
                    // 1) 현재 시간(t)에 이동할 칸에 벽이 없어야 함
                    // 2) 이동 직후(t+1)에 그 칸으로 벽이 내려오지 않아야 함
                    if (map[nr][nc][info.t] == 0) {
                        if (info.t == 7 || map[nr][nc][info.t + 1] == 0) {
                            visited[nr][nc] = true;
                            q.add(new Info(nr, nc, info.t + 1));
                        }
                    }
                }
            }
        }
        System.out.println(0);
    }
}