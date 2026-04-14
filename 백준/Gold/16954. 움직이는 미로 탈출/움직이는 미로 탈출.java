import java.util.*;

public class Main {

    static int[][][] map;
    static boolean[][][] vis;

    static class Info {
        int r, c, t;
        Info(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int[] dr = {0, 1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        map = new int[8][8][8];
        vis = new boolean[8][8][8];

        for (int i = 7; i >= 0; i--) {
            String line = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                map[i][j][0] = line.charAt(j) == '.' ? 0 : 1; 

                for (int k = i-1, l = 1; k >= 0; k--, l++) {
                    map[k][j][l] = map[k+1][j][l-1];
                }
            }
        }

        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 0, 0));
        while (!q.isEmpty()) {
            Info info = q.poll();

            if (info.r == 7 && info.c == 7) {
                System.out.println(1);
                System.exit(0);
            }

            for (int d = 0; d < 9; d++) {
                int nr = info.r + dr[d];
                int nc = info.c + dc[d];

                if (nr < 0 || nr > 7 || nc < 0 || nc > 7) continue;
                if (info.t < 8 && vis[nr][nc][info.t]) continue;
                if (info.t < 8 && map[nr][nc][info.t] == 1 
                    || (info.t < 7 && map[nr][nc][info.t + 1] == 1)) continue;
                
                q.add(new Info(nr, nc, info.t + 1));
            }
        }
        System.out.println(0);
    }
}