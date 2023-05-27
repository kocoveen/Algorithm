import java.io.*;

public class Main {
    static String[] l;

    static int N, M;

    static int[][] board;
    static int[][][] tetro = {
            // 청록색 블록
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}},
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}},
            // 노랑색 블록
            {{0, 0}, {1, 0}, {0, 1}, {1, 1}},
            // 주황색 블록
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}},
            {{0, 0}, {0, 1}, {0, 2}, {1, 0}},
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}},
            {{1, 0}, {1, 1}, {1, 2}, {0, 0}},

            {{0, 1}, {1, 1}, {2, 1}, {0, 0}},
            {{0, 1}, {1, 1}, {2, 1}, {2, 0}},
            {{0, 0}, {1, 0}, {2, 0}, {0, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}},
            // 초록색 블록
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}},
            {{1, 0}, {1, 1}, {0, 1}, {0, 2}},
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}},
            {{0, 1}, {1, 1}, {1, 0}, {2, 0}},
            // 자주색 블록
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}},
            {{1, 0}, {1, 1}, {1, 2}, {0, 1}},
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}},
            {{0, 1}, {1, 1}, {2, 1}, {1, 0}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        M = Integer.parseInt(l[1]);

        board = new int[505][505];
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            for (int j = 0; j < M; j++) board[i][j] = Integer.parseInt(l[j]);
        }

        int ans = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                ans = Math.max(ans, bruteforce(i, j));
        System.out.println(ans);

    }

    private static int bruteforce(int x, int y) {
        int mx = 0;
        for (int i = 0; i < 19; i++) {
            int sum = 0;
            for (int j = 0; j < 4; j++)
                sum += board[x + tetro[i][j][0]][y + tetro[i][j][1]];
            mx = Math.max(mx, sum);
        }
        return mx;
    }
}