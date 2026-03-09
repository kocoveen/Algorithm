import java.util.Scanner;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];

        int N2 = N * N;

        int r = 0;
        int c = 0;

        int nr = 0, nc = 0;

        int K = N+1;
        while ((K = K - 2) > 0) {
            // ↓
            for (int n = 0; n < K; n++) {
                if (N2 == M) {
                    nr = r;
                    nc = c;
                }
                map[r++][c] = N2--;
            }

            // →
            for (int n = 0; n < K; n++) {
                if (N2 == M) {
                    nr = r;
                    nc = c;
                }
                map[r][c++] = N2--;
            }

            // ↑
            for (int n = 0; n < K; n++) {
                if (N2 == M) {
                    nr = r;
                    nc = c;
                }
                map[r--][c] = N2--;
            }

            // ←
            for (int n = 0; n < K; n++) {
                if (N2 == M) {
                    nr = r;
                    nc = c;
                }
                map[r][c--] = N2--;
            }
            
            r++; c++;
        }

        if (N2 == M) {
            nr = r;
            nc = c;
        }

        map[r][c] = N2;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(nr+1).append(" ").append(nc+1);
        System.out.print(sb);
    }
}