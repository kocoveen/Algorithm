import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int N, M, K;

    static String[] line;
    static char[][] board;

    static int[] dr = {1, 1, 1, 0, -1, -1, -1, 0};
    static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

    static Map<String, Integer> stringCountMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        K = Integer.parseInt(line[2]);

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = string.charAt(j);
            }
        }

        while (K-- > 0) {
            String target = br.readLine();
            if (stringCountMap.containsKey(target)) {
                sb.append(stringCountMap.get(target)).append('\n');
                continue;
            }
            stringCountMap.put(target, 0);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(board[i][j] != target.charAt(0)) continue;
                    func(target, 1, new Pair(i, j));
                }
            }

            sb.append(stringCountMap.get(target)).append('\n');
        }
        System.out.print(sb);
    }

    private static void func(String target, int depth, Pair loc) {
        if (target.length() == depth) {
            stringCountMap.put(target, stringCountMap.get(target) + 1);
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nr = (loc.r + dr[i] + N) % N;
            int nc = (loc.c + dc[i] + M) % M;

            if (board[nr][nc] != target.charAt(depth)) continue;
            func(target, depth + 1, new Pair(nr, nc));
        }
    }

    private static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}