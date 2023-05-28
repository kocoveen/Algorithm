import java.io.*;

public class Main {
    static String[] l;

    static int N, L, ans = 0;

    static int[][] board;
    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        L = Integer.parseInt(l[1]);

        board = new int[N][N];
        line = new int[N];
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(l[j]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) line[j] = board[i][j];
            ans += check(line);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) line[j] = board[j][i];
            ans += check(line);
        }
        System.out.println(ans);
    }

    private static int check(int[] line) {
        int idx = 0;
        int cnt = 1;
        while (idx < N - 1) {
            if (Math.abs(line[idx + 1] - line[idx]) > 1) return 0;
            if (line[idx] == line[idx + 1]) {
                idx++;
                cnt++;
            } else if (line[idx] < line[idx + 1]) {
                if (cnt < L) return 0;
                cnt = 1;
                idx++;
            } else {
                if (idx + L >= N) return 0;
                for (int i = idx + 1; i < idx + L; i++)
                    if (line[i] != line[i + 1]) return 0;
                idx += L;
                cnt = 0;
            }
        }
        return 1;
    }
}