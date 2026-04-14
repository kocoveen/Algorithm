import java.util.*;

public class Main {
    static char[][] board = new char[8][8];

    static class Info {
        int r, c, t;
        Info(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }

    static int[] dr = {0, 1, 0, -1, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, 1, 0, -1, 1, 1, -1, -1};

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // 원본 맵을 y축 대칭(거꾸로) 저장
        for (int i = 7; i >= 0; i--) {
            board[i] = sc.nextLine().toCharArray();
        }

        Queue<Info> q = new ArrayDeque<>();
        q.add(new Info(0, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            boolean[][] visited = new boolean[8][8];

            for (int i = 0; i < size; i++) {
                Info info = q.poll();

                if (info.t >= 8 || (info.r == 7 && info.c == 7)) {
                    System.out.println(1);
                    System.exit(0);
                }

                for (int d = 0; d < 9; d++) {
                    int nr = info.r + dr[d];
                    int nc = info.c + dc[d];

                    if (nr < 0 || nr > 7 || nc < 0 || nc > 7 || visited[nr][nc]) continue;

                    // 계산형 벽 체크: 벽이 위로 올라가므로 r + t
                    if (isSafe(nr, nc, info.t) && isSafe(nr, nc, info.t + 1)) {
                        visited[nr][nc] = true;
                        q.add(new Info(nr, nc, info.t + 1));
                    }
                }
            }
        }
        System.out.println(0);
    }

    static boolean isSafe(int r, int c, int t) {
        int originalR = r + t; 
        if (originalR > 7) return true; 
        return board[originalR][c] == '.';
    }
}