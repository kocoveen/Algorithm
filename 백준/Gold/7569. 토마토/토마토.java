import java.util.*;

public class Main {
    
    static int M, N, H; // 가로 세로 높이
    static int[][][] board;
    static Queue<Point> q = new ArrayDeque<>();

    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    static class Point {
        int x, y, z;
        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        board = new int[H][N][M];
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    board[z][y][x] = sc.nextInt();

                    if (board[z][y][x] == 1) {
                        q.add(new Point(x, y, z));
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || nz < 0 || nz >= H) continue;
                if (board[nz][ny][nx] != 0) continue;

                q.add(new Point(nx, ny, nz));
                board[nz][ny][nx] = board[p.z][p.y][p.x] + 1;
            }
        }

        int max = 0;
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (board[z][y][x] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    max = Math.max(max, board[z][y][x]);
                }
            }
        }
    
        System.out.println(max - 1);
    }
}