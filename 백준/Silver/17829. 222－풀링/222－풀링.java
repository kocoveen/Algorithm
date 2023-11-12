import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] board;
    static String[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st[j]);
            }
        }

        int func = func(board, n);
        System.out.println(func);
    }

    private static int func(int[][] tmp, int len) {
        if (len == 1) {
            return tmp[0][0];
        }

        int newLen = len / 2;
        int[][] newTmp = new int[newLen][newLen];

        for (int i = 0; i < newLen; i++) {
            for (int j = 0; j < newLen; j++) {
                int a1 = tmp[i * 2][j * 2];
                int a2 = tmp[i * 2][j * 2 + 1];
                int a3 = tmp[i * 2 + 1][j * 2];
                int a4 = tmp[i * 2 + 1][j * 2 + 1];
                newTmp[i][j] = secondaryMax(a1, a2, a3, a4);
            }
        }

        return func(newTmp, newLen);
    }

    private static int secondaryMax(int a1, int a2, int a3, int a4) {
        int[] tmp = {a1, a2, a3, a4};
        Arrays.sort(tmp);
        return tmp[2];
    }
}