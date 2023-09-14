import java.util.*;

class Solution {

    boolean[][] visited;
    int tr, tc;
    int count;

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    public int[] solution(String[] maps) {

        tr = maps.length;
        tc = maps[0].length();
        visited = new boolean[tr][tc];
        List<Integer> L = new ArrayList<>();
        Stack<Pair> S = new Stack<>();

        for (int r = 0; r < tr; r++) {
            for (int c = 0; c < tc; c++) {

                if (maps[r].charAt(c) == 'X' || visited[r][c]) continue;

                visited[r][c] = true;
                S.push(new Pair(r, c));
                L.add(maps[r].charAt(c) - '0');

                while (!S.isEmpty()) {
                    Pair p = S.pop();
                    for (int i = 0; i < 4; i++) {
                        int nr = p.r + dr[i];
                        int nc = p.c + dc[i];

                        if (!isInBoundary(nr, nc)) continue;
                        if (maps[nr].charAt(nc) == 'X' || visited[nr][nc]) continue;

                        int meal = maps[nr].charAt(nc) - '0';

                        visited[nr][nc] = true;
                        L.set(count, L.get(count) + meal);
                        S.push(new Pair(nr, nc));
                    }
                }
                count++;
            }
        }

        if (L.isEmpty()) {
            return new int[]{-1};
        }

        L.sort(Integer::compareTo);
        int[] answer = new int[L.size()];
        for (int i = 0; i < L.size(); i++) {
            answer[i] = L.get(i);
        }

        for (int i : answer) {
            System.out.println(i);
        }

        return answer;
    }

    private boolean isInBoundary(int nr, int nc) {
        return nr < tr && nc < tc && nr >= 0 && nc >= 0;
    }

    static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}