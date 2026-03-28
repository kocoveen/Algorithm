import java.util.*;

public class Main {
    
    static int N, count;
    static int[][] map;
    static boolean[][] vis;
    static List<Integer> list = new ArrayList<>();

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        vis = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] || map[i][j] == 0) continue;
                count = bfs(i, j);
                list.add(count);
            }
        }

        Collections.sort(list);
        
        System.out.println(list.size());
        for (int elem : list) {
            System.out.println(elem);
        }
    }

    private static int bfs(int r, int c) {
        Queue<Point> queue = new ArrayDeque<>();

        queue.add(new Point(r, c));
        vis[r][c] = true;

        int count = 1;
        while (!queue.isEmpty()) {
            Point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (vis[nr][nc] || map[nr][nc] == 0) continue;
                queue.add(new Point(nr, nc));
                vis[nr][nc] = true;
                count++;
            }
        }

        return count;
    }
}