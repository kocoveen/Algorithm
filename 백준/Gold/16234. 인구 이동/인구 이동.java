import java.util.*;

public class Main {
    static int n, l, r, t;
    static int[][] A, newA;
    static boolean[][] visited;
    static int[] dr = {1, 0, -1, 0}, dc = {0, 1, 0, -1};
    static class Pair {
        int r, c;
        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        n = read(); l = read(); r = read();
        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = read();
            }
        }

        do {
            visited = new boolean[n][n];
            Queue<Pair> q = new ArrayDeque<>();

            newA = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    newA[i][j] = A[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j]) continue;

                    List<Pair> alliance = new ArrayList<>();

                    visited[i][j] = true;
                    q.add(new Pair(i, j));
                    while (!q.isEmpty()) {
                        Pair cur = q.remove();
                        alliance.add(cur);
                        for (int k = 0; k < 4; k++) {
                            int nr = cur.r + dr[k];
                            int nc = cur.c + dc[k];
                            if (nr < 0 || nc < 0 || n <= nr || n <= nc) continue;
                            if (visited[nr][nc]) continue;
                            if (Math.abs(newA[cur.r][cur.c] - newA[nr][nc]) < l || Math.abs(newA[cur.r][cur.c] - newA[nr][nc]) > r) continue;
                            visited[nr][nc] = true;
                            q.add(new Pair(nr, nc));
                        }
                    }

                    int population = sum(alliance) / alliance.size();

                    for (Pair p : alliance) {
                        newA[p.r][p.c] = population;
                    }
                }
            }

            if (arrayEquals(A, newA)) break;
            A = newA;
            t++;
        } while (true);

        System.out.println(t);
    }

    static boolean arrayEquals(int[][] oldA, int[][] newA) {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (oldA[i][j] != newA[i][j]) return false;
            }
        }
        return true;
    }

    private static int sum(List<Pair> alliance) {
        int sum = 0;
        for (Pair p : alliance) {
            sum += A[p.r][p.c];
        }
        return sum;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}