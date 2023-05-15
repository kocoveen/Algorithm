import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int M, N, K;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];
        List<Integer> Area = new ArrayList<>();

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            for (int i = sx; i < ex; i++)
                for (int j = sy; j < ey; j++)
                    board[i][j] = 1;
        }

        int count = 0;
        int area = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0 && !visited[i][j]) {
                    Q.add(new Pair(i, j));
                    visited[i][j] = true;
                    count++; area++;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (!isInBoard(nx, ny)) continue;
                            if (board[nx][ny] == 1 || visited[nx][ny]) continue;
                            visited[nx][ny] = true;
                            Q.add(new Pair(nx, ny));
                            area++;
                        }
                    }
                    Area.add(area);
                    area = 0;
                }
            }
        }
        System.out.println(count);
        Collections.sort(Area);
        for (int i = 0; i < count; i++)
            System.out.printf("%d ", Area.get(i));


    }

    private static boolean isInBoard(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}