import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] dR = {1, 0, -1, 0};
    static int[] dC = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] field = new int[N][M];
            int[][] worm = new int[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int C = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());
                field[R][C] = 1;
            }

            Queue<Pair> W = new ArrayDeque<>();

            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (field[j][k] == 0 || worm[j][k] == 1) continue;
                    W.add(new Pair(j, k));
                    worm[j][k] = 1;
                    count++;
                    while (!W.isEmpty()) {
                        Pair cur = W.remove();
                        for (int l = 0; l < 4; l++) {
                            int nR = cur.R + dR[l];
                            int nC = cur.C + dC[l];
                            if (nR < 0 || nR >= N || nC < 0 || nC >= M) continue;
                            if (field[nR][nC] == 0 || worm[nR][nC] == 1) continue;
                            W.add(new Pair(nR, nC));
                            worm[nR][nC] = 1;
                        }
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
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