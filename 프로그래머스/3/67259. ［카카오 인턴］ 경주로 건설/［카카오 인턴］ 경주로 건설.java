import java.util.*;


class Solution {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private class Road {
        public final int x;
        public final int y;
        public final int cost;
        public final Road prev;

        public Road(int x, int y, int cost, Road prev) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.prev = prev;
        }
    }

    private int bfs(int[][] roads) {
        int result = Integer.MAX_VALUE;
        int size = roads.length - 1;

        Queue<Road> q = new LinkedList<>();
        q.add(new Road(0, 0, 0, null));

        while (!q.isEmpty()) {
            Road current = q.poll();

            if (current.x == size && current.y == size) {
                if (current.cost < result) result = current.cost;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx > size || ny < 0 || ny > size || roads[ny][nx] == 1) continue;

                int cost = 100;
                if (current.prev != null && current.prev.x != nx && current.prev.y != ny) cost += 500;
                cost += current.cost;

                if (roads[ny][nx] >= cost) {
                    roads[ny][nx] = cost;
                    q.add(new Road(nx, ny, cost, current));
                } else if (roads[ny][nx] + 500 >= cost) {
                    q.add(new Road(nx, ny, cost, current));
                }
            }
        }

        return result;
    }

    public int solution(int[][] board) {
        int size = board.length - 1;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                if (board[i][j] == 1) continue;
                board[i][j] = Integer.MAX_VALUE;
            }
        }
        board[0][0] = 0;
        return bfs(board);
    }
}