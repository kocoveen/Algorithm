import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        Loop:
        for (int i = 0; i < T; i++) {

            int l = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());

            int[][] board = new int[l][l];
            board[sX][sY] = 1;

            if (eX == sX && eY == sY) {
                sb.append(board[eX][eY] - 1).append("\n");
                continue;
            }

            Queue<Pair> Q = new ArrayDeque<>();
            Q.add(new Pair(sX, sY));

            while (!Q.isEmpty()) {
                Pair cur = Q.remove();
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (eX == nx && eY == ny) {
                        sb.append(board[cur.x][cur.y]).append("\n");
                        continue Loop;
                    }
                    if (nx < 0 || nx >= l || ny < 0 || ny >= l) continue;
                    if (board[nx][ny] > 0) continue;
                    board[nx][ny] = board[cur.x][cur.y] + 1;
                    Q.add(new Pair(nx, ny));
                }
            }

            for (int[] a : board) {
                for (int b : a)
                    System.out.printf("%d ", b);
                System.out.println();
            }
        }

        System.out.print(sb);
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
