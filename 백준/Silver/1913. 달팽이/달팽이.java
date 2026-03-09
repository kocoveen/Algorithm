public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int[][] map = new int[N][N];
        int r = 0, c = 0, d = 0;
        int curr = N * N;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int targetR = 0, targetC = 0;

        while (curr > 0) {
            map[r][c] = curr;
            if (curr == M) {
                targetR = r+1;
                targetC = c+1;
            }

            if (curr == 1) break;

            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr;
            c = nc;
            curr--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(targetR).append(" ").append(targetC);
        
        System.out.println(sb.toString());
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}