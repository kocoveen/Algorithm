import java.io.*;

class Main {
    static boolean[][] graph;
    static int n;
    static int m;
    static int cnt = 0;

    static void moveHorizontal(int r, int c) {
        if (isArrived(r, c)) {
            cnt++;
            return;
        }

        int nxt_r = r + 1;
        int nxt_c = c + 1;
        if (nxt_c < n && !graph[r][nxt_c]) {
            moveHorizontal(r, nxt_c);
            if (nxt_r < n && !graph[nxt_r][nxt_c] && !graph[nxt_r][c]){
                moveDiagonal(nxt_r, nxt_c);
            }
        }
    }

    static void moveDiagonal(int r, int c) {
        if (isArrived(r, c)) {
            cnt++;
            return;
        }

        int nxt_r = r + 1;
        int nxt_c = c + 1;
        if (nxt_c < n && !graph[r][nxt_c]) {
            moveHorizontal(r, nxt_c);
            if (nxt_r < n && !graph[nxt_r][nxt_c] && !graph[nxt_r][c]){
                moveDiagonal(nxt_r, nxt_c);
            }
        }
        if (nxt_r < n && !graph[nxt_r][c]) moveVertical(nxt_r, c);
    }

    static void moveVertical(int r, int c) {
        if (isArrived(r, c)) {
            cnt++;
            return;
        }
        int nxt_r = r + 1;
        int nxt_c = c + 1;
        if (nxt_r < n && !graph[nxt_r][c]) {
            moveVertical(nxt_r, c);
            if (nxt_c < n && !graph[nxt_r][nxt_c] && !graph[r][nxt_c]){
                moveDiagonal(nxt_r, nxt_c);
            }
        }
    }

    static boolean isArrived(int r, int c) {
        return r == m && c == m;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = n-1;
        graph = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (br.read() == '1') {
                    graph[i][j] = true;
                }
                br.read();
            }
        }

        moveHorizontal(0, 1);
        System.out.println(cnt);
    }
}