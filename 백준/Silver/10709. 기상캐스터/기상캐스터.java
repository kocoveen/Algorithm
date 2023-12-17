import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int r, c;
    static Integer[][] map;
    static Queue<Cloud> q = new LinkedList<>();

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new Integer[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == 'c') {
                    map[i][j] = 0;
                    q.offer(new Cloud(i, j, 0));
                }
            }
        }

        while (!q.isEmpty()) {
            Cloud cur = q.poll();
            int nr = cur.r;
            int nc = cur.c + 1;

            if (nc >= c) {
                continue;
            }

            q.add(new Cloud(nr, nc, cur.t + 1));
            if (map[nr][nc] != null) {
                map[nr][nc] = Math.min(map[nr][nc], cur.t + 1);
            } else {
                map[nr][nc] = cur.t + 1;
            }
        }

        for (Integer[] is : map) {
            for (Integer i : is) {
                System.out.printf("%d ", i != null ? i : -1);
            }
            System.out.println();
        }

    }

    private static class Cloud {
        int r, c, t;

        public Cloud(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }
}