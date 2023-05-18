import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String l = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = l.charAt(j) - '0';
            }
        }

        quad(N, 0, 0);
        System.out.println(sb);
    }

    private static void quad(int n, int r, int c) {
        if (isSingle(n, r, c)) {
            sb.append(board[r][c]);
            return;
        }

        int k = n / 2;

        sb.append("(");

        quad(k, r, c);
        quad(k, r, c + k);
        quad(k, r + k, c);
        quad(k, r + k, c + k);

        sb.append(")");
    }

    private static boolean isSingle(int n, int r, int c) {
        int v = board[r][c];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (board[r + i][c + j] != v)
                    return false;
        return true;
    }

}