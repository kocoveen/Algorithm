import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dx = {1, 0, -1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());
        int[][][] board = new int[Z][X][Y];
        int[][][] tomato = new int[Z][X][Y];

        Queue<Triplet> Q = new ArrayDeque<>();

        for (int k = 0; k < Z; k++)
            for (int i = 0; i < X; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < Y; j++) {
                    board[k][i][j] = Integer.parseInt(st.nextToken());
                    if (board[k][i][j] == 1) {
                        Q.add(new Triplet(k, i, j, 0));
                        tomato[k][i][j] = 1;
                    }

                    if (board[k][i][j] == -1)
                        tomato[k][i][j] = -1;

                }
            }

        boolean isRiped = true;
        for (int[][] a : board)
            for (int[] b : a)
                for (int c : b)
                    if (c == 0) {
                        isRiped = false;
                        break;
                    }

        if (isRiped) {
            System.out.println(0);
            System.exit(0);
        }

        while (!Q.isEmpty()) {
            Triplet cur = Q.remove();
            for (int i = 0; i < 6; i++) {
                int nz = cur.z + dz[i];
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= X || ny < 0 || ny >= Y || nz < 0 || nz >= Z) continue;
                if (tomato[nz][nx][ny] > 0 || board[nz][nx][ny] == -1) continue;
                Q.add(new Triplet(nz, nx, ny, cur.day + 1));
                tomato[nz][nx][ny] = cur.day + 1;
            }
        }

        int max = 0;
        for (int[][] a : tomato)
            for (int[] b : a)
                for (int c : b) {
                    if (c == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    max = Math.max(max, c);
                }

        System.out.println(max);
    }

    private static class Triplet {
        int x;
        int y;
        int z;
        int day;

        public Triplet(int z, int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }
}