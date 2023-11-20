import java.io.*;
import java.util.*;

public class Main {

    static String[] st;
    static String str;
    static int R, C, N;
    static int[][] times;
    static boolean[][] isBombs;
    static Set<int[]> removed = new HashSet<>();
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
        for (int[] pos : removed) {
            isBombs[pos[0]][pos[1]] = false;
            times[pos[0]][pos[1]] = 0;
        }
        removed.clear();
    }

    private static void running() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (isBombs[i][j]) {
                    times[i][j]--;
                    if (times[i][j] == 0) {
                        explode(i, j);
                    }
                }
            }
        }
    }

    private static void explode(int r, int c) {
        removed.add(new int[]{r, c});
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                removed.add(new int[]{nr, nc});
            }
        }
    }


    private static void printBombs() {
        for (boolean[] isBomb : isBombs) {
            for (boolean b : isBomb) {
                if (b) {
                    System.out.printf("%c", 'O');
                } else {
                    System.out.printf("%c", '.');
                }
            }
            System.out.println();
        }
    }
}