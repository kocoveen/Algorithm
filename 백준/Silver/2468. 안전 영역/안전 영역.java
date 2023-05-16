import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, min = 101, max = 0, maxHeight = 0;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        Queue<Pair> Q = new ArrayDeque<>();
        for (int h = min - 1; h < max; h++) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (board[i][j] <= h || visited[i][j]) continue;
                    Q.add(new Pair(i, j));
                    count++;
                    visited[i][j] = true;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (!isInBoard(nx, ny)) continue;
                            if (visited[nx][ny] || board[nx][ny] <= h) continue;
                            Q.add(new Pair(nx, ny));
                            visited[nx][ny] = true;
                        }
                    }

                }
            }
            maxHeight = Math.max(maxHeight, count);
            visited = new boolean[N][N];
        }

        System.out.print(maxHeight);
    }

    private static boolean isInBoard(int nx, int ny) {
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