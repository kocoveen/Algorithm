import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Loop:
        for (int n = 0; n < N; n++) {

            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            char[][] building = new char[h][w];
            int[][] fireTime = new int[h][w];
            int[][] escapeTime = new int[h][w];

            Queue<Pair> F = new ArrayDeque<>();
            Queue<Pair> H = new ArrayDeque<>();

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    char c = line.charAt(j);
                    building[i][j] = c;
                    fireTime[i][j] = escapeTime[i][j] = -1;

                    if (c == '*') {
                        F.add(new Pair(i, j));
                        fireTime[i][j] = 0;
                    }

                    if (c == '@') {
                        H.add(new Pair(i, j));
                        escapeTime[i][j] = 0;
                    }
                }
            }

            while (!F.isEmpty()) {
                Pair cur = F.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) continue;
                    if (fireTime[nx][ny] >= 0 || building[nx][ny] == '#') continue;
                    F.add(new Pair(nx, ny));
                    fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                }
            }

            while (!H.isEmpty()) {
                Pair cur = H.remove();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        sb.append(escapeTime[cur.x][cur.y] + 1).append("\n");
                        continue Loop;
                    }
                    if (escapeTime[nx][ny] >= 0 || building[nx][ny] == '#') continue;
                    if (fireTime[nx][ny] != -1 && fireTime[nx][ny] <= escapeTime[cur.x][cur.y] + 1) continue;
                    H.add(new Pair(nx, ny));
                    escapeTime[nx][ny] = escapeTime[cur.x][cur.y] + 1;
                }
            }
            sb.append("IMPOSSIBLE").append("\n");

        }
        System.out.print(sb);
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