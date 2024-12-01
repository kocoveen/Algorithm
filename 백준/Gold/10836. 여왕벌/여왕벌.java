public class Main {

    static int M, N;
    static int[][][] tmp;
    static int[] growArray;

    public static void main(String[] args) throws Exception {
        M = read(); N = read();
        tmp = new int[N][M][M];
        growArray = new int[3];

        for (int i = 0; i < N; i++) {
            fill(i);
        }

        print();
    }

    static void fill(int n) throws Exception {
        growArray[0] = read();
        growArray[1] = read();
        growArray[2] = read();

        for (int i = M-1; i >= 0; i--) { tmp[n][i][0] = getGrow(); }
        for (int i = 1; i < M; i++) { tmp[n][0][i] = getGrow(); }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < M; j++) {
                tmp[n][i][j] = maxGrow(n, i, j);
            }
        }
    }

    private static int getGrow() {
        if (growArray[0] != 0) {
            growArray[0]--;
            return 0;
        }
        if (growArray[1] != 0) {
            growArray[1]--;
            return 1;
        }
        return 2;
    }

    static int maxGrow(int n, int r, int c) {
        return max(tmp[n][r-1][c], tmp[n][r][c-1], tmp[n][r-1][c-1]);
    }

    static int max(int... values) {
        int max = 0;
        for (int i : values) {
            max = Math.max(max, i);
        }
        return max;
    }

    static void print() {
        int[][] printArray = new int[M][M];

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < M; j++) {
                    printArray[i][j] += tmp[k][i][j];
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(printArray[i][j] + 1 + " ");
            }
            System.out.println();
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}