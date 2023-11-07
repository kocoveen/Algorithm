import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] board;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String string = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = string.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < Math.min(n - i, m - j); k++) {
                    // 모든 꼭짓점이 같은지 검사
                    if (isSameAllVertex(i, j, k)) {
                        max = Math.max(max, (k + 1) * (k + 1));
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isSameAllVertex(int r, int c, int size) {
        int lt = board[r][c]; // 좌상단
        int lb = board[r + size][c]; // 좌하단
        int rt = board[r][c + size]; // 우상단
        int rb = board[r + size][c + size]; // 우하단
        return lt == lb && lb == rt && rt == rb;
    }
}