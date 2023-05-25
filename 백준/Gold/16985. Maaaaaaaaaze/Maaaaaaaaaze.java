import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static String[] l;
    static int min = Integer.MAX_VALUE;

    static int[][][] mazes;
    static int[][][] tmpMaze = new int[5][5][5];

    static int[][] arr = new int[5][2];
    static boolean[] vis = new boolean[5];

    static int[][][] distMaze = new int[5][5][5];
    static boolean[][][] visMaze;

    static Queue<Triplet> Q = new ArrayDeque<>();

    static int[] df = {0, 0, 0, 0, 1, -1};
    static int[] dr = {1, 0, -1, 0, 0, 0};
    static int[] dc = {0, 1, 0, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        mazes = new int[5][5][5];

        for (int k = 0; k < 5; k++)
            for (int i = 0; i < 5; i++) {
                l = br.readLine().split(" ");
                for (int j = 0; j < 5; j++)
                    mazes[k][i][j] = Integer.parseInt(l[j]);
            }

        locate(0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    private static void locate(int depth) {
        if (depth == 5) {
            rotate(0);
            return;
        }

        for (int i = 0; i < 5; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            arr[depth][0] = i;
            locate(depth + 1);
            vis[i] = false;
        }
    }

    private static void rotate(int depth) {
        if (depth == 5) {
            init();
            int dist = bfs();
            if (dist == 0) return;
            min = Math.min(min, dist);
            return;
        }

        for (int i = 0; i < 4; i++) {
            arr[depth][1] = i;
            tmpMaze[depth] = change(arr[depth]);
            rotate(depth + 1);
        }
    }

    private static void init() {
        distMaze = new int[5][5][5];
        visMaze = new boolean[5][5][5];
    }

    private static int[][] change(int[] info) {
        int[][] tmp = new int[5][5];

        switch (info[1]) {
            case 0 -> {
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        tmp[i][j] = mazes[info[0]][i][j];
            }
            case 1 -> {
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        tmp[j][4 - i] = mazes[info[0]][i][j];

            }
            case 2 -> {
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        tmp[4 - i][4 - j] = mazes[info[0]][i][j];

            }
            case 3 -> {
                for (int i = 0; i < 5; i++)
                    for (int j = 0; j < 5; j++)
                        tmp[4 - j][i] = mazes[info[0]][i][j];
            }
        }
        return tmp;
    }

    private static int bfs() {
        if (tmpMaze[0][0][0] == 0) return 0;
        Q = new ArrayDeque<>();
        Q.add(new Triplet(0, 0, 0));
        visMaze[0][0][0] = true;
        while (!Q.isEmpty()) {
            Triplet cur = Q.remove();
            for (int i = 0; i < 6; i++) {
                int nf = cur.f + df[i];
                int nr = cur.r + dr[i];
                int nc = cur.c + dc[i];
                if (OOB(nf, nr, nc)) continue;
                if (visMaze[nf][nr][nc] || tmpMaze[nf][nr][nc] == 0) continue;
                if (nf == 4 && nr == 4 && nc == 4) return distMaze[cur.f][cur.r][cur.c] + 1;
                Q.add(new Triplet(nf, nr, nc));
                visMaze[nf][nr][nc] = true;
                distMaze[nf][nr][nc] = distMaze[cur.f][cur.r][cur.c] + 1;
            }
        }
        return 0;
    }

    private static boolean OOB(int nf, int nr, int nc) {
        return nf < 0 || nf >= 5 || nr < 0 || nr >= 5 || nc < 0 || nc >= 5;
    }


    private static class Triplet {
        int f;
        int r;
        int c;

        public Triplet(int f, int r, int c) {
            this.f = f;
            this.r = r;
            this.c = c;
        }
    }
    private static void printMaze(int[][][] M) {
        for (int[][] maze : M) {
            for (int[] m : maze) {
                for (int i : m) {
                    System.out.printf("%d ", i);
                }
                System.out.println();
            }
        }
    }
}