import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int t = 0;
        int size = 0;
        while (true) {
            // 바깥 치즈 찾기
            var list = getOutermostCheeses();

            if (list.isEmpty()) {
                break;
            }

            size = list.size();

            // 바깥 치즈 녹이기
            melt(list);
            t++;
        }

        System.out.println(t);
        System.out.println(size);
    }

    private static void melt(List<int[]> list) {
        for (int[] c : list) {
            map[c[0]][c[1]] = 0;
        }
    }

    private static List<int[]> getOutermostCheeses() {
        List<int[]> outermostList = new ArrayList<>();
        
        boolean[][] vis = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (vis[nr][nc]) continue;

                if (map[nr][nc] == 1) {
                    outermostList.add(new int[]{nr, nc});
                } else {
                    q.add(new int[]{nr, nc});
                }
                vis[nr][nc] = true;
            }
        }

        return outermostList;
    }
}