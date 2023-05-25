import java.io.*;
import java.util.Stack;

public class Main {
    static String[] l;

    static int N, M, R, C, K;

    static int[][] board;
    static int[] cmdLine;

    // 주사위 윗 면 인덱스 : 1
    // 주사위 밑 면 인덱스 : 3
    static int[] diceV = {0, 0, 0, 0}; // 주사위 전개도의 세로
    static int[] diceH = {0, 0, 0, 0}; // 주사위 전개도의 가로

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);
        R = Integer.parseInt(l[2]);
        C = Integer.parseInt(l[3]);
        K = Integer.parseInt(l[4]);

        board = new int[N][M];
        cmdLine = new int[K];

        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < M; j++)
                board[i][j] = Integer.parseInt(l[j]);
        }

        l = br.readLine().split(" ");
        for (int i = 0; i < K; i++) cmdLine[i] = Integer.parseInt(l[i]);

        for (int i = 0; i < K; i++) {
            int nr = R + dr[cmdLine[i] - 1];
            int nc = C + dc[cmdLine[i] - 1];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            R = nr;
            C = nc;
            diceRoll(cmdLine[i]);
            
            if (board[R][C] == 0) {
                board[R][C] = diceH[3];
            } else {
                diceH[3] = board[R][C];
                diceV[3] = board[R][C];
                board[R][C] = 0;
            }

            System.out.println(diceH[1]);
        }
    }

    private static void diceRoll(int cmd) {
        switch (cmd) {
            case 1 -> {
                int tmp = diceH[3];
                for (int i = 3; i > 0; i--) diceH[i] = diceH[i - 1];
                diceH[0] = tmp;
                diceV[1] = diceH[1];
                diceV[3] = diceH[3];
            }

            case 2 -> {
                int tmp = diceH[0];
                for (int i = 0; i < 3; i++) diceH[i] = diceH[i + 1];
                diceH[3] = tmp;
                diceV[1] = diceH[1];
                diceV[3] = diceH[3];
            }

            case 3 -> {
                int tmp = diceV[0];
                for (int i = 0; i < 3; i++) diceV[i] = diceV[i + 1];
                diceV[3] = tmp;
                diceH[1] = diceV[1];
                diceH[3] = diceV[3];
            }

            case 4 -> {
                int tmp = diceV[3];
                for (int i = 3; i > 0; i--) diceV[i] = diceV[i - 1];
                diceV[0] = tmp;
                diceH[1] = diceV[1];
                diceH[3] = diceV[3];
            }
        }


    }
}