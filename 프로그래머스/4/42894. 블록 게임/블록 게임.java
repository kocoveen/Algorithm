import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    // 동, 남, 서, 북
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };
    static int n;

    public int solution(int[][] board) {
        n = board.length;

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> p = new ArrayDeque<>();
        Queue<Rectangle> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0 && !visited[i][j]) {
                   visited[i][j] = true;
                   p.add(new int[]{i, j});

                   Rectangle rec = new Rectangle(board[i][j]);
                   rec.setMinRC(i, j);
                   rec.setMaxRC(i, j);

                   while (!p.isEmpty()) {
                       int[] pos = p.poll();
                       for (int k = 0; k < 4; k++) {
                           int nr = pos[0] + dr[k];
                           int nc = pos[1] + dc[k];
                           if (nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                           if (visited[nr][nc]) continue;
                           if (board[nr][nc] != board[pos[0]][pos[1]]) continue;

                           rec.setMaxRC(nr, nc);
                           rec.setMinRC(nr, nc);

                           visited[nr][nc] = true;
                           p.add(new int[]{nr, nc});
                       }
                   }

                    q.add(rec);
                }
            }
        }

        // 검은 블록 채우기
        for (int c = 0; c < n; c++) {
            fillBlackBlock(board, c);
        }

        int successCnt = 0;
        int failureCnt = 0;
        while (!q.isEmpty() && failureCnt < q.size()) {
            Rectangle rec = q.poll();

            int bb = 0; // 검은 블록
            int cb = 0; // 본인 색깔 블록
            int em = 0; // 빈 곳
            for (int i = rec.minR; i <= rec.maxR; i++) {
                for (int j = rec.minC; j <= rec.maxC; j++) {
                    if (board[i][j] == rec.val) cb++;
                    else if (board[i][j] == -1) bb++;
                    else if (board[i][j] == 0) em++;
                }
            }

            if (em > 0 || cb != 4 || bb != 2) {
                failureCnt++;
                q.add(rec);
            } else {
                successCnt++;
                failureCnt = 0;
                fillBlank(board, rec);
                for (int j = rec.minC; j <= rec.maxC; j++) {
                    fillBlackBlock(board, j);
                }

            }
        }

        return successCnt;
    }

    private void print(int[][] board) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] >= 0 ? board[i][j] : " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void fillBlackBlock(int[][] board, int c) {
        int r = 0;
        while (r < n && board[r][c] <= 0) {
            board[r++][c] = -1; // 검은 블록이 내려옴
        }
    }

    private void fillBlank(int[][] board, Rectangle rec) {
        for (int i = rec.minR; i <= rec.maxR; i++) {
            for (int j = rec.minC; j <= rec.maxC; j++) {
                board[i][j] = 0;
            }
        }
    }

    private static class Rectangle {
        int val, minR = n, minC = n, maxR, maxC;

        Rectangle(int val) {
            this.val = val;
        }

        public void setMinRC(int r, int c) {
            minR = Math.min(minR, r);
            minC = Math.min(minC, c);
        }

        public void setMaxRC(int r, int c) {
            maxR = Math.max(maxR, r);
            maxC = Math.max(maxC, c);
        }
    }
}