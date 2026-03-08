import java.util.Scanner;

public class Main {

    static int N;

    static int[][] board = new int[5][5];
    static boolean[][] called = new boolean[5][5];

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int number = 0;
        int count = 0;
        while (number++ <= 25) {
            N = sc.nextInt();

            Point p = getPoint(N);

            called[p.r][p.c] = true;

            count += getLine(p.r, p.c);

            if (count >= 3) break;
        }
        System.out.println(number);
    }

    private static Point getPoint(int n) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == n) {
                    return new Point(i, j);
                }
            }
        }
        return null;
    }

    private static int getLine(int r, int c) {
        int lines = 0;

        // '\' 대각선 확인
        if (r - c == 0) {
            boolean complete = true;
            for (int i = 0; i < 5; i++) {
                if (!called[i][i]) {
                    complete = false;
                    break;
                }
            }

            if (complete) {
                lines++;
            }
        }

        // '/' 대각선 확인
        if (r + c == 4) {
            boolean complete = true;
            for (int i = 0; i < 5; i++) {
                if (!called[i][4-i]) {
                    complete = false;
                    break;
                }
            }

            if (complete) {
                lines++;
            }
        }

        // '-' 확인
        boolean rowComplete = true;
        for (int i = 0; i < 5; i++) {
            if (!called[r][i]) {
                rowComplete = false;
                break;
            }
        }
        if (rowComplete) {
            lines++;
        }
        

        // '|' 확인
        boolean colComplete = true;
        for (int i = 0; i < 5; i++) {
            if (!called[i][c]) {
                colComplete = false;
                break;
            }
        }
        if (colComplete) {
            lines++;
        }

        return lines;
    }
}