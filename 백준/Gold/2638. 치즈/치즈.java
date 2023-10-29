import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][] visit;
    static int[][] surface;
    static int[][] board;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);

        visit = new boolean[n][m];
        surface = new int[n][m];
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        while (isUnclean()) {
            visit = new boolean[n][m];
            surface = new int[n][m];

            q.offer(new int[]{0, 0});
            visit[0][0] = true;
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nr = cur[0] + dr[i];
                    int nc = cur[1] + dc[i];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                    if (visit[nr][nc]) continue;
                    if (board[nr][nc] == 1) {
                        surface[nr][nc]++;
                    } else {
                        q.offer(new int[]{nr, nc});
                        visit[nr][nc] = true;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (surface[i][j] >= 2) {
                        board[i][j] = 0;
                    }
                }
            }
            answer++;
        }

        System.out.println(answer);

    }

    private static boolean isUnclean() {
        for (int[] ints : board) {
            for (int i : ints) {
                if (i > 0) {
                    return true;
                }
            }
        }
        return false;
    }
}