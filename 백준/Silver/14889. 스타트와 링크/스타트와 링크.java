import java.io.*;

public class Main {
    static String[] l;

    static int N, minDiff = Integer.MAX_VALUE;

    static int[][] board;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        vis = new boolean[N];
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(l[j]);
        }

        func(0, 0);
        System.out.println(minDiff);
    }

    private static void func(int depth, int startPlayer) {
        if (depth == N / 2) {
            minDiff = Math.min(minDiff, stat());
            return;
        }

        for (int i = startPlayer; i < N; i++) {
            vis[i] = true;
            func(depth + 1, i + 1);
            vis[i] = false;
        }
    }

    private static int stat() {
        int star = 0, link = 0;
        for (int i = 0; i < N - 1; i++)
            for (int j = i; j < N; j++) {
                if (vis[i] && vis[j]) star += board[i][j] + board[j][i];
                else if (!vis[i] && !vis[j]) link += board[i][j] + board[j][i];
            }
        return Math.abs(star - link);
    }
}