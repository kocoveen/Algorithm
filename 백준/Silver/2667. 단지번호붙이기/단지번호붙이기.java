import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N;

    static int[][] board;
    static boolean[][] visited;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> Area = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++)
                board[i][j] = line.charAt(j) - '0';
        }

        int count = 0;
        Queue<Pair> Q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    int area = 0;
                    Q.add(new Pair(i, j));
                    visited[i][j] = true;
                    count++; area++;
                    while (!Q.isEmpty()) {
                        Pair cur = Q.remove();
                        for (int k = 0; k < 4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];
                            if (!isInBoard(nx, ny)) continue;
                            if (board[nx][ny] == 0 || visited[nx][ny]) continue;
                            Q.add(new Pair(nx, ny));
                            visited[nx][ny] = true;
                            area++;
                        }
                    }
                    Area.add(area);
                }
            }
        }
        Collections.sort(Area);
        System.out.println(count);
        for (Integer i : Area)
            System.out.println(i);
    }

    private static boolean isInBoard(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
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