import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    static int N, M, year;
    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        year = 0;

        while (true) {
            year++;
            melting();
            initVisited();
            int check = statue();
            if (check == 0) {
                System.out.println(0);
                System.exit(0);
            }
            if (check == 2) break;
        }
        System.out.println(year);
    }

    private static void initVisited() {
        for (int i = 0; i < N; i++) Arrays.fill(visited[i], false);
    }

    private static int statue() {
        int x = 0, y = 0;
        int Gcount1 = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (board[i][j] > 0) {
                    x = i;
                    y = j;
                    Gcount1++;
                }

        if (Gcount1 == 0) return 0;
        int Gcount2 = 0;

        Queue<Pair> Q = new ArrayDeque<>();
        Q.add(new Pair(x, y));
        visited[x][y] = true;

        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            Gcount2++;
            for (int l = 0; l < 4; l++) {
                int nx = cur.x + dx[l];
                int ny = cur.y + dy[l];
                if (!boundaryCheck(nx, ny) || board[nx][ny] == 0 || visited[nx][ny]) continue;
                Q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
        }
        if (Gcount1 == Gcount2) return 1;
        return 2;
    }

    private static void melting() {
        int[][] count = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) continue;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (boundaryCheck(nx, ny) && board[nx][ny] == 0) count[i][j]++;
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                board[i][j] = Math.max(0, board[i][j] - count[i][j]);
    }

    private static boolean boundaryCheck(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
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