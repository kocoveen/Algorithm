import java.io.*;
import java.util.*;

public class Main {

    static String[] st;
    static String str;
    static int R, C, N;
    static int[][] times;
    static boolean[][] isBombs;
    static Deque<int[]> removed = new ArrayDeque<>();
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split(" ");
        R = Integer.parseInt(st[0]);
        C = Integer.parseInt(st[1]);
        N = Integer.parseInt(st[2]);

        isBombs = new boolean[R][C];
        times = new int[R][C];

        for (int i = 0; i < R; i++) {
            str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'O') {
                    isBombs[i][j] = true;
                    times[i][j] = 3;
                }
            }
        }

        for (int i = 0; i <= N; i++) {
            if (i > 0 && i % 2 == 0) {
                addBombsInEmptyArea();
            }
            removedBombs();
            running();
        }
        printBombs();
    }

    private static void addBombsInEmptyArea() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!isBombs[i][j]) {
                    times[i][j] = 3;
                    isBombs[i][j] = true;
                }
            }
        }
    }

    private static void removedBombs() {
        while (!removed.isEmpty()) {
            int[] pos = removed.pollLast();
            isBombs[pos[0]][pos[1]] = false;
            times[pos[0]][pos[1]] = 0;
            for (int i = 0; i < 4; i++) {
                int nr = pos[0] + dr[i];
                int nc = pos[1] + dc[i];
                if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                    isBombs[nr][nc] = false;
                    times[nr][nc] = 0;
                }
            }
        }
    }

    private static void running() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isBombs[i][j]) {
                    times[i][j]--;
                    if (times[i][j] == 0) {
                        removed.add(new int[]{i, j});
                    }
                }
            }
        }
    }

    private static void printBombs() {
        StringBuilder sb = new StringBuilder();
        for (boolean[] isBomb : isBombs) {
            for (boolean b : isBomb) {
                if (b) {
                    sb.append('O');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}