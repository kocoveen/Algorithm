import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        board = new char[N][N * 2];
        for (int i = 0; i < N; i++)
            Arrays.fill(board[i], ' ');

        tree(N, 0, 0);
        printBoard();
    }

    private static void tree(int n, int r, int c) {
        if (n == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n * 2; j++) {
                    if (j == 5) continue;
                    if (i == 2)
                        board[r + i][c + j] = '*';
                    else if ((i + j) % 2 == 0 && 0 < j && j < 4)
                        board[r + i][c + j] = '*';
                }
            }
            return;
        }
        
        int k = n / 2;

        tree(k, r, c + k);
        tree(k, r + k, c);
        tree(k, r + k, c + n);
    }

    private static void printBoard() {
        for (char[] b : board) {
            for (char c : b)
                sb.append(c);
            sb.append("\n");
        }
        System.out.print(sb);
    }

}