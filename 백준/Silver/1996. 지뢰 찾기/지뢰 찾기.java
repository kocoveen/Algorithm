import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] map;
    static int[] dr = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        Queue<Pair> q = new LinkedList<>();

        for (int r = 0; r < n; r++) {
            String str = br.readLine();
            for (int c = 0; c < n; c++) {
                char v = str.charAt(c);
                if ('1' <= v && v <= '9') {
                    q.add(new Pair(r, c, v - '0'));
                    map[r][c] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int k = 0; k < 8; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (isOverBoundary(nr, nc) || isMine(nr, nc)) {
                    continue;
                }
                map[nr][nc] += cur.v;
            }
        }

        for (int[] ints : map) {
            for (int i : ints) {
                if (i >= 0) {
                    if (i >= 10) {
                        sb.append("M");
                    } else {
                        sb.append(i);
                    }
                } else {
                    sb.append("*");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isMine(int nr, int nc) {
        return map[nr][nc] == -1;
    }

    private static boolean isOverBoundary(int nr, int nc) {
        return nr < 0 || n <= nr || nc < 0 || n <= nc;
    }

    private static class Pair {
        int r;
        int c;
        int v;

        public Pair(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
}