import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static int[][] board;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dfs(new Pipe(new int[][]{{0, 0}, {0, 1}}, State.HORIZONTAL));
        System.out.println(answer);
    }

    private static void dfs(Pipe cur) {
        moveHorizontal(cur);
        moveVertical(cur);
        moveDiagonal(cur);
    }

    private static void moveHorizontal(Pipe cur) {
        if (State.VERTICAL == cur.state) {
            return;
        }

        Pipe nxt = cur.moveHorizontal();

        if (isOverBoundary(nxt.location) || isWall(nxt.location)) {
            return;
        }

        if (nxt.isArrived(n, n)) {
            answer++;
            return;
        }

        dfs(nxt);
    }

    private static void moveVertical(Pipe cur) {
        if (State.HORIZONTAL == cur.state) {
            return;
        }

        Pipe nxt = cur.moveVertical();

        if (isOverBoundary(nxt.location) || isWall(nxt.location)) {
            return;
        }

        if (nxt.isArrived(n, n)) {
            answer++;
            return;
        }

        dfs(nxt);
    }

    private static void moveDiagonal(Pipe cur) {
        Pipe nxt = cur.moveDiagonal();

        if (isOverBoundary(nxt.location) || isDiagonalWall(nxt.location)) {
            return;
        }

        if (nxt.isArrived(n, n)) {
            answer++;
            return;
        }

        dfs(nxt);
    }

    private static boolean isDiagonalWall(int[][] location) {
        return isWall(location)
                || board[location[1][0] - 1][location[1][1]] == 1
                || board[location[1][0]][location[1][1] - 1] == 1;
    }

    private static boolean isWall(int[][] location) {
        return board[location[1][0]][location[1][1]] == 1;
    }

    private static boolean isOverBoundary(int[][] location) {
        return location[1][0] >= n || location[1][1] >= n;
    }

    static class Pipe {
        int[][] location;
        State state;

        public Pipe(int[][] location, State state) {
            this.location = location;
            this.state = state;
        }

        public boolean isArrived(int r, int c) {
            return location[1][0] == r - 1 && location[1][1] == c - 1;
        }

        public Pipe moveHorizontal() {
            int rearR = this.location[1][0];
            int rearC = this.location[1][1];
            int frontR = this.location[1][0];
            int frontC = this.location[1][1] + 1;
            return makeNewPipe(new int[][]{{rearR, rearC}, {frontR, frontC}}, State.HORIZONTAL);
        }

        public Pipe moveVertical() {
            int rearR = this.location[1][0];
            int rearC = this.location[1][1];
            int frontR = this.location[1][0] + 1;
            int frontC = this.location[1][1];
            return makeNewPipe(new int[][]{{rearR, rearC}, {frontR, frontC}}, State.VERTICAL);
        }

        public Pipe moveDiagonal() {
            int rearR = this.location[1][0];
            int rearC = this.location[1][1];
            int frontR = this.location[1][0] + 1;
            int frontC = this.location[1][1] + 1;
            return makeNewPipe(new int[][]{{rearR, rearC}, {frontR, frontC}}, State.DIAGONAL);
        }

        private Pipe makeNewPipe(int[][] location, State state) {
            return new Pipe(location, state);
        }
    }

    enum State {
        HORIZONTAL, VERTICAL, DIAGONAL
    }
}