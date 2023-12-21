import java.io.*;

public class Main {

    static char[][] map;
    static int n, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int[][] dir = new int[][]{{0, 1}, {1, 0}};

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                for (int[] d : dir) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr == n || nc == n) continue;
                    swap(r, c, nr, nc);
                    max = Math.max(max, findMax(r, c, nr, nc));
                    swap(r, c, nr, nc);
                }
            }
        }
        System.out.println(max);
    }

    private static int findMax(int r, int c, int nr, int nc) {
        int max = 0;
        max = Math.max(max, findMaxRow(c));
        max = Math.max(max, findMaxCol(r));
        if (c != nc) max = Math.max(max, findMaxRow(nc));
        if (r != nr) max = Math.max(max, findMaxCol(nr));
        return max;
    }

    private static int findMaxRow(int c) {
        int max = 0;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (map[i-1][c] == map[i][c]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    private static int findMaxCol(int r) {
        int max = 1;
        int cur = 1;
        for (int i = 1; i < n; i++) {
            if (map[r][i-1] == map[r][i]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    private static void swap(int r, int c, int nr, int nc) {
        char tmp = map[r][c];
        map[r][c] = map[nr][nc];
        map[nr][nc] = tmp;
    }
}