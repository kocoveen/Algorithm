import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int ans = 0;

    static char[][] board = new char[5][5];
    static int[] arr = new int[7];
    static boolean[] visited;

    static Queue<int[]> Q;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) board[i] = br.readLine().toCharArray();

        func(0, 0, 0);
        System.out.println(ans);
    }

    private static void func(int depth, int s, int dasomCnt) {
        if (depth - dasomCnt > 3) return;
        if (depth == 7) {
            visited = new boolean[7];
            bfs(arr[0] / 5, arr[0] % 5);
            return;
        }

        for (int i = s; i < 25; i++) {
            int r = i / 5;
            int c = i % 5;
            arr[depth] = i;
            func(depth + 1, i + 1, board[r][c] == 'S' ? dasomCnt + 1 : dasomCnt);
        }
    }

    private static void bfs(int r, int c) {
        int num = 1;
        Q = new ArrayDeque<>();
        Q.add(new int[]{r, c});
        visited[0] = true;
        while (!Q.isEmpty()) {
            int[] cur = Q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int next = 5 * nr + nc;
                for (int k = 0; k < 7; k++) {
                    if (visited[k] || arr[k] != next) continue;
                    visited[k] = true;
                    num++;
                    Q.add(new int[] {nr, nc});
                }

            }
        }
        if (num == 7) ans++;
    }
}