import java.io.*;

public class Main {
    static String[] line;

    static int N;
    static int max = Integer.MIN_VALUE;

    static int[][] board;
    static int[][] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new int[N][N];
        tmp = new int[N][N];
        for (int i = 0; i < N; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < N; j++)
                board[i][j] = Integer.parseInt(line[j]);
        }

        func(0, board);
        System.out.println(max);
    }

    private static void func(int round, int[][] prev) {
        if (round == 5) {
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    max = Math.max(max, prev[i][j]);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int[][] next = execute(prev, dir);
            func(round + 1, next);
        }
    }

    // 우: 0, 상: 1, 좌: 2, 하: 3
    private static int[][] execute(int[][] prev, int dir) {
        int[][] next = new int[N][N];
        for (int i = 0; i < N; i++) System.arraycopy(prev[i], 0, next[i], 0, N);

        if (dir == 0) { // 오른쪽 이동
            for (int i = 0; i < N; i++) {
                // 땡기기
                int index = N - 1;
                for (int j = N - 1; j >= 0; j--)
                    if (next[i][j] != 0) next[i][index--] = next[i][j];

                for (int j = index; j >= 0; j--) next[i][j] = 0;

                // 합치기
                for (int j = N - 1; j > 0; j--) {
                    if (next[i][j] == next[i][j - 1]) {
                        next[i][j] += next[i][j - 1];
                        next[i][j - 1] = 0;
                    }
                }

                // 땡기기
                index = N - 1;
                for (int j = N - 1; j >= 0; j--)
                    if (next[i][j] != 0) next[i][index--] = next[i][j];

                for (int j = index; j >= 0; j--) next[i][j] = 0;
            }

        } else if (dir == 1) { // 위로 이동
            for (int j = 0; j < N; j++) {
                // 땡기기
                int index = 0;
                for (int i = 0; i < N; i++)
                    if (next[i][j] != 0) next[index++][j] = next[i][j];

                for (int i = index; i < N; i++) next[i][j] = 0;

                // 합치기
                for (int i = 0; i < N - 1; i++) {
                    if (next[i][j] == next[i + 1][j]) {
                        next[i][j] += next[i + 1][j];
                        next[i + 1][j] = 0;
                    }
                }

                // 땡기기
                index = 0;
                for (int i = 0; i < N; i++)
                    if (next[i][j] != 0) next[index++][j] = next[i][j];

                for (int i = index; i < N; i++) next[i][j] = 0;
            }

        } else if (dir == 2) { // 왼쪽으로 이동
            for (int i = 0; i < N; i++) {
                // 땡기기
                int index = 0;
                for (int j = 0; j < N; j++)
                    if (next[i][j] != 0) next[i][index++] = next[i][j];

                for (int j = index; j < N; j++) next[i][j] = 0;

                // 합치기
                for (int j = 0; j < N - 1; j++) {
                    if (next[i][j] == next[i][j + 1]) {
                        next[i][j] += next[i][j + 1];
                        next[i][j + 1] = 0;
                    }
                }

                // 땡기기
                index = 0;
                for (int j = 0; j < N; j++)
                    if (next[i][j] != 0) next[i][index++] = next[i][j];

                for (int j = index; j < N; j++) next[i][j] = 0;
            }

        } else { // 아래쪽으로 이동
            for (int j = 0; j < N; j++) {
                // 땡기기
                int index = N - 1;
                for (int i = N - 1; i >= 0; i--)
                    if (next[i][j] != 0) next[index--][j] = next[i][j];

                for (int i = index; i >= 0; i--) next[i][j] = 0;

                // 합치기
                for (int i = N - 1; i > 0; i--) {
                    if (next[i][j] == next[i - 1][j]) {
                        next[i][j] += next[i - 1][j];
                        next[i - 1][j] = 0;
                    }
                }

                // 땡기기
                index = N - 1;
                for (int i = N - 1; i >= 0; i--)
                    if (next[i][j] != 0) next[index--][j] = next[i][j];

                for (int i = index; i >= 0; i--) next[i][j] = 0;
            }
        }
        return next;
    }

}