import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Point> jhs = new ArrayList<>();
    static List<Point> fires = new ArrayList<>();

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        for (int r = 0; r < R; r++) {
            String line = sc.next();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);

                if (map[r][c] == 'J') {
                    jhs.add(new Point(r, c));
                } else if (map[r][c] == 'F') {
                    fires.add(new Point(r, c));
                }
            }
        }

        int[][] jihoon = bfs(jhs);
        int[][] fire = bfs(fires);

        // print(jihoon);
        // print(fire);

        int min = Integer.MAX_VALUE;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (r != 0 && c != 0 && r != R-1 && c != C-1) continue;
                if (jihoon[r][c] == 0) continue;

                if (fire[r][c] == 0 || fire[r][c] > jihoon[r][c]) {
                    min = Math.min(min, jihoon[r][c]);
                }
            }
        }
        System.out.println(min == Integer.MAX_VALUE ? "IMPOSSIBLE" : min);
    }

    private static int[][] bfs(List<Point> points) {
        int[][] timeMap = new int[R][C];
        Queue<Point> q = new ArrayDeque<>();
        q.addAll(points);

        for (Point p : points) {
            timeMap[p.r][p.c] = 1;
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (map[nr][nc] == '#') continue;
                if (timeMap[nr][nc] > 0) continue;

                int next = timeMap[p.r][p.c] + 1;
                q.add(new Point(nr, nc));
                timeMap[nr][nc] = next;
            }
        }

        return timeMap;
    }

    // private static void print(int[][] map) {
    //     for (int r = 0; r < R; r++) {
    //         for (int c = 0; c < C; c++) {
    //             IO.print("%2d ".formatted(map[r][c]));
    //         }
    //         IO.println();
    //     }
    //     IO.println();
    // }
}