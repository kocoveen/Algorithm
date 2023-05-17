import java.io.*;
import java.util.*;

public class Main {
    static int N, cnt;

    static int[][] board;
    static boolean[][] vis;
    static int[][] dist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        vis = new boolean[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        Queue<Pair> Q = new ArrayDeque<>();
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || vis[i][j]) continue;
                Q.add(new Pair(i, j));
                cnt++;
                board[i][j] = cnt;
                vis[i][j] = true;
                while (!Q.isEmpty()) {
                    Pair cur = Q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (!isInBoundary(nx, ny) || board[nx][ny] == 0 || vis[nx][ny]) continue;
                        Q.add(new Pair(nx, ny));
                        vis[nx][ny] = true;
                        board[nx][ny] = cnt;
                    }
                }
            }
        }

        int minD = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) continue;

                dist = new int[N][N];
                Q = new ArrayDeque<>();

                Q.add(new Pair(i, j));
                dist[i][j] = 1;
                Loop:
                while (!Q.isEmpty()) {
                    Pair cur = Q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nx = cur.x + dx[k];
                        int ny = cur.y + dy[k];
                        if (!isInBoundary(nx, ny) || board[nx][ny] == board[i][j]) continue;
                        if (dist[nx][ny] > 0) continue;
                        if (board[nx][ny] != 0) {
                            minD = Math.min(dist[cur.x][cur.y], minD);
                            break Loop;
                        }
                        Q.add(new Pair(nx, ny));
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                    }
                }
            }
        }
        System.out.println(minD - 1);
    }

    private static boolean isInBoundary(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}