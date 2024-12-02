import java.util.*;

public class Main {

    static int N, M;
    static int sr, sc, er, ec, mr, mc;
    static int[][] roadMap; // 도로 위치
    static int[][] warriorMap; // 전사의 위치
    static int[][][] petrifyMap; // 석화의 응시 위치

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] dirArray = {
        {2, 0, 3}, 
        {3, 1, 2}, 
        {1, 2, 0}, 
        {0, 3, 1}
    };

    // 최단 거리 구하는 변수들
    static List<int[]> route = new ArrayList<>();
    static boolean[][] visited;
    static int[][] routeMap;

    static int dir;

    public static void main(String[] args) throws Exception {
        N = read(); M = read();
        sr = read(); sc = read(); er = read(); ec = read();
        mr = sr; mc = sc;

        warriorMap = new int[N][N];
        for (int i = 0; i < M; i++) {
            int r = read(); int c = read();
            warriorMap[r][c]++;
        }

        roadMap = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                roadMap[i][j] = read();
            }
        }
        petrifyMap = new int[4][N][N];

        getRoute();
        for (int[] cur : route) {
            removeWarrior(cur[0], cur[1]);
            petrify();
        }
    }

    static int petrify() {
        int max = 0; int maxDir = -1;
        for (int i = 0; i < 4; i++) {
            int count = 0;
            count = petrifyStraight(i, r, c) + petrifyStraightLeft(i, r, c) + petrifyStraightRight(i, r, c);
            if (max < count) {
                max = 0;
                maxDir = i;
            }
        }
    }
    
    static int petrifyStraight(int dir, int r, int c) {
        if (r < 0 || N <= r || c < 0 || N <= c) return 0;
        if (warriorMap[r][c] > 0) return warriorMap[r][c];
        return petrifyStraight(r + dr[dirArray[dir][1]], c + dc[dirArray[dir][1]]);
    }

    static int petrifyStraightLeft(int dir, int r, int c) {
        if (r < 0 || N <= r || c < 0 || N <= c) return 0;
        return petrifyStraight(r + dr[dirArray[dir][1]], c + dc[dirArray[dir][1]]) + petrifyStraightLeft(r + dr[dirArray[dir][0]], c + dc[dirArray[dir][0]]);
    }

    static int petrifyStraightRight(int dir, int r, int c) {
        if (r < 0 || N <= r || c < 0 || N <= c) return 0;
        return petrifyStraight(r + dr[dirArray[dir][1]], c + dc[dirArray[dir][1]]) + petrifyStraightRight(r + dr[dirArray[dir][2]], c + dc[dirArray[dir][2]]);
    }



    static void removeWarrior(int r, int c) {
        if (warriorMap[r][c] > 0) {
            warriorMap[r][c] = 0;
        }
    }

    static void getRoute() {
        visited = new boolean[N][N];
        int[][] routeMap = new int[N][N];
        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{sr, sc}); routeMap[sr][sc]++;
        visited[sr][sc] = true;
        while (!q.isEmpty()) {
            int[] p = q.remove();
            for (int i = 0; i < 4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];

                if (roadMap[nr][nc] == 0) continue;
                if (routeMap[nr][nc] > 0) continue;
                routeMap[nr][nc] = routeMap[p[0]][p[1]] + 1;
            }
        }

        if (!visited[er][ec]) {
            System.out.println(-1);
            System.exit(0);
        }

        int r = sr; int c = sc;
        while (r != er || c != ec) {
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (routeMap[nr][nc] == routeMap[r][c] + 1) {
                    route.add(new int[]{nr, nc});
                    r = nr; c = nc;
                    break;
                }
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}