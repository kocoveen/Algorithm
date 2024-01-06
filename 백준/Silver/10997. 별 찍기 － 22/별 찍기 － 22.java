public class Main {

    static int n;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        n = read();
        board = new char[4 * n - 1][4 * n - 3];

        if (n > 1) {
            draw(n, 0, 4 * n - 4);
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < board.length; i++) {
                if (i == 1) {
                    sb.append(board[i][0]);
                } else {
                    for (int j = 0; j < board[i].length; j++) {
                        sb.append(board[i][j] == '*' ? board[i][j] : ' ');
                    }
                }

                sb.append('\n');
            }
            
            System.out.print(sb);
        } else {
            System.out.print('*');
        }
    }

    private static void draw(int n, int r, int c) {
        int height = 4 * n - 1;
        int width = 4 * n - 3;

        for (int i = 1; i < width; i++) board[r][c--] = '*';
        for (int i = 1; i < height; i++) board[r++][c] = '*';
        for (int i = 1; i < width; i++) board[r][c++] = '*';
        for (int i = 1; i < height - 1; i++) board[r--][c] = '*';

        r++; c--;
        board[r][c] = '*';

        if (n == 2) {
            board[r][c-1] = '*';
            board[r+1][c-1] = '*';
            board[r+2][c-1] = '*';
            return;
        }

        draw(n - 1, r, c - 1);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}