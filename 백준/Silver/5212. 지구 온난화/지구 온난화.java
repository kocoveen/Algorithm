import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char[][] board;
    static String[] st;
    static List<int[]> islands = new ArrayList<>();
    static List<int[]> newOcean = new ArrayList<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(" ");
        int r = Integer.parseInt(st[0]);
        int c = Integer.parseInt(st[1]);

        board = new char[r + 2][c + 2];
        for (int i = 0; i < r + 2; i++) {
            for (int j = 0; j < c + 2; j++) {
                board[i][j] = '.';
            }
        }

        for (int i = 1; i <= r; i++) {
            String row = br.readLine();
            for (int j = 1; j <= c; j++) {
                char ch = row.charAt(j - 1);
                if (ch == 'X') {
                    islands.add(new int[]{i, j});
                }
                board[i][j] = ch;
            }
        }

        for (int[] island : islands) {
            int t = 0;
            for (int i = 0; i < 4; i++) {
                int nr = island[0] + dr[i];
                int nc = island[1] + dc[i];
                if (board[nr][nc] == '.') {
                    t++;
                }
            }
            if (t >= 3) {
                newOcean.add(island);
            }
        }

        for (int[] ints : newOcean) {
            board[ints[0]][ints[1]] = '.';
        }

        int mnr = board.length - 1, mxr = 0, mnc = board[0].length - 1, mxc = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    mnr = Math.min(mnr, i);
                    mxr = Math.max(mxr, i);
                    mnc = Math.min(mnc, j);
                    mxc = Math.max(mxc, j);
                }
            }
        }

        print(mnr, mxr, mnc, mxc);

    }

    private static void print(int mnr, int mxr, int mnc, int mxc) {
        for (int i = mnr; i <= mxr; i++) {
            for (int j = mnc; j <= mxc; j++) {
                System.out.printf("%c", board[i][j]);
            }
            System.out.println();
        }
    }

}