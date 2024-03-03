public class Main {

    static int n, m, k;
    static int rowSumMin = 100_000;
    static int[][] map, rotOper;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        k = read();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = read();
            }
        }

        rotOper = new int[k][3];
        for (int i = 0; i < k; i++) {
            rotOper[i][0] = read(); // r
            rotOper[i][1] = read(); // c
            rotOper[i][2] = read(); // s
        }

        visited = new boolean[k];

        dfs(0, map);
        System.out.println(rowSumMin);
    }


    private static void dfs(int depth, int[][] curMap) {
        if (depth == k) {
            for (int i = 0; i < n; i++) {
                rowSumMin = Math.min(rowSumMin, getRowSum(curMap[i]));
            }
            return;
        }

        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            int[][] newMap = rotation(curMap, rotOper[i][0]-1, rotOper[i][1]-1, rotOper[i][2]);
            dfs(depth + 1, newMap);
            visited[i] = false;
        }
    }

    private static int[][] rotation(int[][] originMap, int r, int c, int s) {
        int[][] map = getNewMap(originMap);

        while (s > 0) {
            int tmp = map[r-s][c-s];
            // 상
            for (int i = 0; i < 2 * s; i++) {
                map[r-s + i][c-s] = map[r-s + i+1][c-s];
            }

            // 좌
            for (int i = 0; i < 2 * s; i++) {
                map[r+s][c-s + i] = map[r+s][c-s + i+1];
            }

            // 하
            for (int i = 0; i < 2 * s; i++) {
                map[r+s - i][c+s] = map[r+s - i-1][c+s];
            }

            // 우
            for (int i = 0; i < 2 * s; i++) {
                map[r-s][c+s - i] = map[r-s][c+s - i-1];
            }

            // 마지막으로 덮인 갚 갱신
            map[r-s][c-s + 1] = tmp;
            s--;
        }
        return map;
    }

    private static int[][] getNewMap(int[][] originMap) {
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = originMap[i][j];
            }
        }
        return map;
    }

    private static int getRowSum(int[] row) {
        int sum = 0;
        for (int i : row) sum += i;
        return sum;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}