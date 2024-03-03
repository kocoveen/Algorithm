import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

    static int n;
    static int[][] players;
    static int[] battingOrder = new int[9]; // 타순
    static boolean[] visited = new boolean[9];
    static int mxRun;

    public static void main(String[] args) throws Exception {
        n = read();
        players = new int[n][9];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 9; j++) {
                players[i][j] = read();
            }
        }

        visited[0] = true;
        dfs(0);
        System.out.println(mxRun);
    }

    private static void dfs(int depth) {
        if (depth == 9) {
            int run = getRunByCurrentBattingOrder(battingOrder);
            mxRun = Math.max(mxRun, run);
            return;
        }

        if (depth == 3) {
            dfs(depth + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            battingOrder[depth] = i;
            dfs(depth + 1);
            visited[i] = false;
        }

    }

    static int getRunByCurrentBattingOrder(int[] battingOrder) {
        int run = 0; // 점수
        int out; // 아웃
        int idx = 0; // 게임 첫 타자

        for (int inning = 0; inning < n; inning++) {
            out = 0; // 아웃 초기화
            int base = 0; // 3루, 2루, 1루, 홈 상태 초기화

            while (out < 3) {
                int batting = players[inning][battingOrder[idx]];
                if (batting == 0) {
                    out++;
                } else {
                    base = (base + 1) << batting; // 루타만큼 비트 이동
                    run += Integer.bitCount(base >> 4); // 뒤에서 4번째 비트보다 큰 비트들의 1을 세어, 점수에 합
                    base %= (1 << 4); // 뒤에서 4번째 비트보다 큰 비트는 전부 0으로 바꿈
                }
                // 다음 타자로
                idx = (idx + 1) % 9;
            }
        }
        return run;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}