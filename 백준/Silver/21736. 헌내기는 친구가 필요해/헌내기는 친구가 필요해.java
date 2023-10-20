import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] campus;
    static boolean[][] visited;
    static Pair me;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        campus = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == 'X') {
                    campus[i][j] = -1;
                } else if (row.charAt(j) == 'P') {
                    campus[i][j] = 1;
                } else if (row.charAt(j) == 'I') {
                    me = new Pair(i, j);
                }
            }
        }

        Queue<Pair> q = new LinkedList<>();
        q.offer(me);
        visited[me.r][me.c] = true;

        while(!q.isEmpty()) {
            Pair cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (!(nr >= 0 && nr < n && nc >= 0 && nc < m)) continue;
                if (campus[nr][nc] == -1 || visited[nr][nc]) continue;

                if (campus[nr][nc] == 1) {
                    answer++;
                }
                q.add(new Pair(nr, nc));
                visited[nr][nc] = true;
            }
        }
        if (answer == 0) {
            bw.write("TT");
        } else {
            bw.write(answer + "");
        }
        bw.flush();
    }

    public static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}