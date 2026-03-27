import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int R, C, N;
    static int[][] map;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static Queue<Point> q = new ArrayDeque<>();

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        R = Integer.parseInt(split[0]);
        C = Integer.parseInt(split[1]);
        N = Integer.parseInt(split[2]);

        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                if (line.charAt(j) == 'O') map[i][j] = 3;
            }
        }

        for (int k = 0; k < N; k++) {
            // 시간 경과 및 폭탄 터짐
            timeIsTicking();
            if (k % 2 != 0) {
                // 폭탄 추가
                addBomb();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j] > 0 ? 'O' : '.');
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void timeIsTicking() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    map[i][j]--;
                    if (map[i][j] == 0) {
                        q.add(new Point(i, j));
                    }
                }
            }
        }

        // 한번에 터뜨리기
        while (!q.isEmpty()) {
            Point p = q.poll();
            map[p.r][p.c] = 0;
            for (int k = 0; k < 4; k++) {
                int nr = p.r + dr[k];
                int nc = p.c + dc[k];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                map[nr][nc] = 0;
            }
        }
    }

    private static void addBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0) map[i][j] = 3;
            }
        }
    }
}