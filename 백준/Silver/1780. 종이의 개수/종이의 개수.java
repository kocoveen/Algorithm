import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int z = 0, p = 0, m = 0;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] l = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(l[j]);
        }
        rec(N, 0, 0);
        System.out.println(m);
        System.out.println(z);
        System.out.println(p);
    }

    private static void rec(int n, int r, int c) {
        if (isSingle(n, r, c)) {
            switch (board[r][c]) {
                case 1 -> p++;
                case 0 -> z++;
                case -1 -> m++;
            }
            return;
        }

        int k = n / 3;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                rec(k, r + i * k, c + j * k);
    }

    private static boolean isSingle(int n, int r, int c) {
        for (int i = r; i < r + n; i++)
            for (int j = c; j < c + n; j++)
                if (board[i][j] != board[r][c])
                    return false;
        return true;
    }
}