import java.util.*;

public class Main {

    static int W, H;
    static int[][] map;
    
    static int[][] dy = {{1, 1, 0, -1, -1, 0}, {1, 1, 0, -1, -1, 0}};
    static int[][] dx = {
        {0, -1, -1, -1, 0, 1}, // y % 2 == 0
        {1, 0, -1, 0, 1, 1}    // y % 2 == 1
    };

    static boolean[][] vis;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        W = sc.nextInt();
        H = sc.nextInt();
        map = new int[H+2][W+2]; // 0, 0 부터 시작
        vis = new boolean[H+2][W+2];

        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <= W; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        int count = 0;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int y = p[0];
            int x = p[1];

            for (int i = 0; i < 6; i++) {
                int ny = y + dy[y % 2][i];
                int nx = x + dx[y % 2][i];

                if (ny < 0 || ny > H+1 || nx < 0 || nx > W+1) continue;
                if (vis[ny][nx]) continue;

                if (map[ny][nx] == 0) {
                    q.add(new int[]{ny, nx});
                    vis[ny][nx] = true;
                } else {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}