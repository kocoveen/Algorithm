import java.util.Scanner;

public class Main {

    static int[][] board;
    static int[][] mat = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int N = sc.nextInt();
            int D = sc.nextInt();
            
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }

            var rotated = rotate(board, D);
            print(rotated);
        }
        System.out.print(sb);
    }

    private static int[][] rotate(int[][] prev, int angle) {
        int[][] next = copy(prev);

        int step = ((angle + 360) / 45) % 8;
        int level = prev.length / 2;

        for (int l = level, r = 0, c = 0; l > 0; l--, r++, c++) {
            for (int s = 0; s < step; s++) {
                int tmp = next[(level - l)][(level - l)];

                for (int i = 0; i < 8; i++) {
                    int nr = r + mat[i/2][0] * l;
                    int nc = c + mat[i/2][1] * l;

                    int nextTmp = next[nr][nc];
                    next[nr][nc] = tmp;
                    tmp = nextTmp;

                    r = nr; c = nc;
                }
            }
        }

        return next;
    }

    private static int[][] copy(int[][] prev) {
        int[][] next = new int[prev.length][prev.length];
        for (int i = 0; i < prev.length; i++) {
            System.arraycopy(prev[i], 0, next[i], 0, prev[i].length);
        }
        return next;
    }

    private static void print(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
    }
}