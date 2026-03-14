import java.util.Scanner;

public class Main {

    static int[][] board = new int[19][19];

    static int[] dr = {1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] != 0) {
                    for (int d = 0; d < 4; d++) {
                        if (search(i, j, d)) {
                            System.out.println(board[i][j]);
                            System.out.println((i+1) + " " + (j+1));
                            System.exit(0);
                        }
                    }
                }
            }
        }

        System.out.println(0);
    }

    private static boolean search(int r, int c, int d) {
        int color = board[r][c];

        int prevR = r - dr[d];
        int prevC = c - dc[d];
        if (prevR >= 0 && prevR < 19 && prevC >= 0 && prevC < 19) {
            if (board[prevR][prevC] == color) { 
                return false;
            }
        }

        int count = 1;
        int nr = r, nc = c;
        while (true) {
            nr += dr[d];
            nc += dc[d];
            if (nr < 0 || nc < 0 || nr > 18 || nc > 18) break;
            if (board[nr][nc] != color) break;
            count++;
        }

        return count == 5;
    }
}