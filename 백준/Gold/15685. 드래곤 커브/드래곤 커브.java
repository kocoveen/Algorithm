import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String[] l;

    static int N, cnt;

    static boolean[][] board;
    static int[] gens;
    static List< List<Pair> > L;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        board = new boolean[101][101];

        // x축은 → 방향, y축은 ↓ 방향
        gens = new int[N];
        L = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            l = br.readLine().split(" ");
            L.add(new ArrayList<>());
            int x = Integer.parseInt(l[0]);
            int y = Integer.parseInt(l[1]);
            int dir = Integer.parseInt(l[2]);
            int gen = Integer.parseInt(l[3]);
            L.get(i).add(new Pair(x, y, dir));
            if (!board[y][x]) board[y][x] = true;
            gens[i] = gen;
        }

        int h = 0;
        for (List<Pair> k : L) {
            for (int g = 0; g < gens[h]; g++) {

                for (int i = k.size() - 1; i >= 0; i--) {
                    Pair dirPair = k.get(i);
                    Pair curPair = k.get(k.size() - 1);
                    int nx = curPair.x + dx[curPair.dir];
                    int ny = curPair.y + dy[curPair.dir];
                    int dir = (dirPair.dir + 1) % 4;
                    k.add(new Pair(nx, ny, dir));
                    if (!board[ny][nx]) board[ny][nx] = true;
                }

            }
            Pair curPair = k.get(k.size() - 1);
            int nx = curPair.x + dx[curPair.dir];
            int ny = curPair.y + dy[curPair.dir];
            int dir = (curPair.dir + 1) % 4;
            k.add(new Pair(nx, ny, dir));
            if (!board[ny][nx]) board[ny][nx] = true;

            h++;
        }

        for (int i = 0; i < 100; i++)
            for (int j = 0; j < 100; j++)
                if (isSquare(i, j)) cnt++;

        System.out.println(cnt);
    }

    private static boolean isSquare(int i, int j) {
        return board[j][i] && board[j + 1][i] && board[j][i + 1] && board[j + 1][i + 1];
    }

    private static class Pair {
        int x;
        int y;
        int dir;

        public Pair(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
