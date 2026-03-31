import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int N, M;
    static int[][] board;
    static Queue<Point> q = new ArrayDeque<>();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");
        N = Integer.parseInt(st[0]);
        M = Integer.parseInt(st[1]);

        board = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st[j]);
                board[i][j] = value;

                if (board[i][j] == 1) {
                    q.add(new Point(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (board[nr][nc] != 0) continue;

                board[nr][nc] = board[p.r][p.c] + 1;
                q.add(new Point(nr, nc));
            }
        }
        
        int max = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) {
                    System.out.println(-1);
                    System.exit(0);
                } else {
                    max = Math.max(max, board[i][j]);
                }
            }
        }
        System.out.println(max - 1);
    }
}