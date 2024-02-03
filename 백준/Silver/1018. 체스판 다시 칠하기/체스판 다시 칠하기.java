import java.io.*;

public class Main {

    static String[] ln;
    static int n, m;
    static int min = Integer.MAX_VALUE;
    static char[][] board;
    static char[][][] correctBoard = new char[2][8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ln = br.readLine().split(" ");
        n = Integer.parseInt(ln[0]);
        m = Integer.parseInt(ln[1]);

        board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String l = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = l.charAt(j);
            }
        }

        for (int k = 0; k < 2; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    char color = (k + i + j) % 2 == 0 ? 'B' : 'W';
                    correctBoard[k][i][j] = color;
                }
            }
        }

        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                min = Math.min(min, countIncorrect(i, j));
            }
        }
        System.out.println(min);
    }

    private static int countIncorrect(int r, int c) {
        int result = min;
        for (int k = 0; k < 2; k++) {
            int sum = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (correctBoard[k][i][j] != board[r + i][c + j]) sum++;
                }
            }
            result = Math.min(result, sum);
        }
        return result;
    }
}