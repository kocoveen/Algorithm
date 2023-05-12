import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][][] W;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }

        W = new int[N][M][2];
        System.out.println(bfs());
    }

    private static int bfs() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                W[i][j][0] = W[i][j][1] = -1;
        W[0][0][0] = W[0][0][1] = 1;
        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(0, 0, 0));

        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            if (cur.x == N -1 && cur.y == M -1) return W[cur.x][cur.y][cur.broken];
            int nextW = W[cur.x][cur.y][cur.broken] + 1;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (isOutOfRange(nx, ny)) continue;
                if (board[nx][ny] == 0 && W[nx][ny][cur.broken] == -1) {
                    W[nx][ny][cur.broken] = nextW;
                    Q.add(new Pair(nx, ny, cur.broken));
                }
                if (cur.broken != 1 && board[nx][ny] == 1 && W[nx][ny][1] == -1) {
                    W[nx][ny][1] = nextW;
                    Q.add(new Pair(nx, ny, 1));
                }
            }
        }
        return -1;
    }

    private static boolean isOutOfRange(int nx, int ny) {
        return nx < 0 || nx >= N || ny < 0 || ny >= M;
    }

    private static class Pair {
        int x;
        int y;
        int broken;

        public Pair(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
}