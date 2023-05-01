import java.io.*;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static char[][] Board;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++)
                Board[i][j] = row.charAt(j);
        }

        System.out.println(Math.min(minBoard('B'), minBoard('W')));
    }

    private static int minBoard(char color) {
        int v;
        int[][] Sum = new int[N + 1][M + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ((i + j) % 2 == 0)
                    v = Board[i][j] == color ? 1 : 0;
                else
                    v = Board[i][j] != color ? 1 : 0;
                Sum[i + 1][j + 1] = Sum[i][j + 1] + Sum[i + 1][j] - Sum[i][j] + v;
            }
        }

        int c = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++)
            for (int j = 1; j <= M - K + 1; j++)
                c = Math.min(c, Sum[i + K - 1][j + K - 1] - Sum[i - 1][j + K - 1] - Sum[i + K - 1][j - 1] + Sum[i - 1][j - 1]);
        return c;
    }
}