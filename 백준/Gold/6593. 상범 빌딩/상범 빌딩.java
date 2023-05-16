import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int L, R, C;
    static Triplet SL;
    static Triplet EL;

    static char[][][] building;
    static boolean[][][] visited;
    static int[][][] dist;

    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, -1, 0, 1, 0, 0};
    static int[] dc = {1, 0, -1, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            dist = new int[L][R][C];

            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        building[l][r][c] = line.charAt(c);
                        if (building[l][r][c] == 'S')
                            SL = new Triplet(l, r, c);
                        if (building[l][r][c] == 'E')
                            EL = new Triplet(l, r, c);
                    }
                }
                br.readLine();
            }

            Queue<Triplet> Q = new ArrayDeque<>();
            Q.add(SL);
            dist[SL.z][SL.x][SL.y] = 0;
            visited[SL.z][SL.x][SL.y] = true;
            boolean found = false;
            while (!Q.isEmpty()) {
                Triplet cur = Q.remove();
                for (int i = 0; i < 6; i++) {
                    int nz = cur.z + dl[i];
                    int nx = cur.x + dr[i];
                    int ny = cur.y + dc[i];
                    if (EL.z == nz && EL.x == nx && EL.y == ny) {
                        found = true;
                        sb.append("Escaped in ").append(dist[cur.z][cur.x][cur.y] + 1).append(" minute(s).").append("\n");
                        break;
                    }
                    if (!isInBoard(nz, nx, ny)) continue;
                    if (visited[nz][nx][ny] || building[nz][nx][ny] == '#') continue;
                    Q.add(new Triplet(nz, nx, ny));
                    dist[nz][nx][ny] = dist[cur.z][cur.x][cur.y] + 1;
                    visited[nz][nx][ny] = true;
                }
                if (found) break;
            }

            if (!found) sb.append("Trapped!").append("\n");
        }
        System.out.print(sb);
    }

    private static boolean isInBoard(int nz, int nx, int ny) {
        return nx >= 0 && nx < R && ny >= 0 && ny < C && nz >= 0 && nz < L;
    }

    private static class Triplet {
        int z;
        int x;
        int y;

        public Triplet(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
}