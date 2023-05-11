import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (board[i][j] == 1)
                    Q.add(new Pair(i, j));

        while (!Q.isEmpty()) {
            Pair cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] != 0) continue;
                Q.add(new Pair(nx, ny));
                if (board[nx][ny] == 0) board[nx][ny] = board[cur.x][cur.y] + 1;
                else board[nx][ny] = Math.min(board[nx][ny], board[cur.x][cur.y] + 1);
            }
        }

        int max = -1;
        for (int[] b : board) {
            for (int i : b) {
                if (i == 0) {
                    System.out.println(-1);
                    System.exit(0);
                } else if (i > 0 && max < i)
                    max = i;
            }
        }
        System.out.println(max - 1);
    }

    public static class Pair {
        Integer x;
        Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}