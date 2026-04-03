import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int max;
    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] vis;

    static List<int[]> virus = new ArrayList<>();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        vis = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
        System.out.println(max);
    }

    static void dfs(int depth) {
        if (depth == 3) {
            max = Math.max(max, bfs());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2 || map[i][j] == 1) continue;
                map[i][j] = 1;
                dfs(depth + 1);
                map[i][j] = 0;
            }
        }
    }

    static int bfs() {
        int[][] tmp = init();

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (vis[nr][nc] || tmp[nr][nc] == 1) continue;

                q.add(new int[]{nr, nc});
                vis[nr][nc] = true;
                tmp[nr][nc] = 2;
            }
        }

        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < M; j++) {
        //         IO.print(tmp[i][j] + " ");
        //     }
        //     IO.println();
        // }
        // IO.println();

        int safeZone = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0) safeZone++;
            }
        }
        return safeZone;
    }

    static int[][] init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                vis[i][j] = false;
            }
        }

        for (int[] v : virus) {
            q.add(v);
            vis[v[0]][v[1]] = true;
        }

        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }
}