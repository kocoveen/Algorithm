import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int K, H, W;

    static int[][] board;
    static int[][][] dist;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] hx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] hy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[H][W];
        dist = new int[K + 1][H][W];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i <= K; i++)
            for (int j = 0; j < H; j++)
                Arrays.fill(dist[i][j], -1);

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(0, 0, 0));
        for (int i = 0; i <= K; i++)
            dist[i][0][0] = 0;

        if (0 == H - 1 && 0 == W - 1) {
            System.out.println(0);
            System.exit(0);
        }
        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            int next = dist[cur.horse][cur.x][cur.y] + 1;
            if (cur.horse < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + hx[i];
                    int ny = cur.y + hy[i];
                    if (nx == H - 1 && ny == W - 1) {
                        System.out.println(next);
                        System.exit(0);
                    }
                    if (!isInBoundary(nx, ny)) continue;
                    if (dist[cur.horse + 1][nx][ny] != -1 || board[nx][ny] == 1) continue;
                    Q.add(new Pair(nx, ny, cur.horse + 1));
                    dist[cur.horse + 1][nx][ny] = next;
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx == H - 1 && ny == W - 1) {
                    System.out.println(next);
                    System.exit(0);
                }
                if (!isInBoundary(nx, ny)) continue;
                if (dist[cur.horse][nx][ny] != -1 || board[nx][ny] == 1) continue;
                Q.add(new Pair(nx, ny, cur.horse));
                dist[cur.horse][nx][ny] = next;
            }
        }
        System.out.println(-1);
    }

    private static boolean isInBoundary(int nx, int ny) {
        return nx >= 0 && nx < H && ny >= 0 && ny < W;
    }

    private static class Pair {
        int x;
        int y;
        int horse;

        public Pair(int x, int y, int horse) {
            this.x = x;
            this.y = y;
            this.horse = horse;
        }
    }
}