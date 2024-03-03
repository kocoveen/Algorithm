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
            out = 0; // 현재 이닝에서 아웃의 수
            boolean[] base = new boolean[4]; // true : 해당 베이스에 선수가 있음, false : 해당 베이스에 선수가 없음
            
            while (out < 3) {
                switch (players[inning][battingOrder[idx]]) {
                    // 1루타
                    case 1: {
                        if (base[3]) {
                            run++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                        }
                        base[1] = true;
                        break;
                    }
                    // 2루타
                    case 2: {
                        if (base[3]) {
                            run++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            run++;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;
                        break;
                    }
                    // 3루타
                    case 3: {
                        if (base[3]) {
                            run++;
                        }
                        if (base[2]) {
                            run++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            run++;
                            base[1] = false;
                        }
                        base[3] = true;
                        break;
                    }
                    // 홈런
                    case 4: {
                        if (base[3]) {
                            run++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            run++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            run++;
                            base[1] = false;
                        }
                        run++;
                        break;
                    }
                    // 아웃(0)
                    default: {
                        out++;
                    }
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