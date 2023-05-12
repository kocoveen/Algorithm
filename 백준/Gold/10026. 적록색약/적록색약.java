import java.io.*;
import java.util.*;

public class Main {
    static int[] dR = {1, 0, -1, 0};
    static int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        int[][] nor = new int[N][N];
        int[][] rg = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                board[i][j] = line.charAt(j);
        }

        Queue<Pair> Q = new ArrayDeque<>();
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nor[i][j] != 0) continue;
                Q.add(new Pair(i, j));
                count++;
                nor[i][j] = count;
                while (!Q.isEmpty()) {
                    Pair cur = Q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nr = cur.R + dR[k];
                        int nc = cur.C + dC[k];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (nor[nr][nc] != 0) continue;
                        if (board[cur.R][cur.C] != board[nr][nc]) continue;
                        Q.add(new Pair(nr, nc));
                        nor[nr][nc] = count;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (board[i][j] == 'R')
                    board[i][j] = 'G';

        count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rg[i][j] != 0) continue;
                Q.add(new Pair(i, j));
                count++;
                rg[i][j] = count;
                while (!Q.isEmpty()) {
                    Pair cur = Q.remove();
                    for (int k = 0; k < 4; k++) {
                        int nr = cur.R + dR[k];
                        int nc = cur.C + dC[k];
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                        if (rg[nr][nc] != 0) continue;
                        if (board[cur.R][cur.C] != board[nr][nc]) continue;
                        Q.add(new Pair(nr, nc));
                        rg[nr][nc] = count;
                    }
                }
            }
        }
        int maxN = 0;
        for (int[] l : nor)
            for (int i : l)
                maxN = Math.max(maxN, i);

        int max = 0;
        for (int[] l : rg)
            for (int i : l)
                max = Math.max(max, i);

        System.out.print(maxN + " " + max);
    }
    
    private static class Pair {
        int R;
        int C;

        public Pair(int R, int C) {
            this.R = R;
            this.C = C;
        }
    }
}