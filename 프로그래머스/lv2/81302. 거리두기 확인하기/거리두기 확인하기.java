import java.util.*;

class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    int[][] room;
    Queue<int[]> Q;
    List<int[]> L; // P 좌표

    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int k = 0; k < 5; k++) {
            L = new ArrayList<>();
            String[] place = places[k]; // 대기실
            boolean valid = true; // 준수 여부

            // 대기실 초기화
            room = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (place[i].charAt(j) == 'P') {
                        L.add(new int[]{i, j});
                    } else if (place[i].charAt(j) == 'X') {
                        room[i][j] = -1;
                    }
                }
            }

            for (int[] p : L) {
                if (!valid) break;

                Q = new LinkedList<>();
                Q.add(new int[]{p[0], p[1]});
                boolean[][] visited = new boolean[5][5];

                while (!Q.isEmpty() && valid) {
                    int[] cur = Q.remove();
                    visited[cur[0]][cur[1]] = true;

                    for (int i = 0; i < 4; i++) {
                        int nr = cur[0] + dr[i];
                        int nc = cur[1] + dc[i];
                        if (nr > 4 || nc > 4 || nr < 0 || nc < 0) continue;
                        if (room[nr][nc] == -1 || visited[nr][nc]) continue;

                        if (place[nr].charAt(nc) == 'P') {
                            if (room[cur[0]][cur[1]] + 1 <= 2) {
                                valid = false;
                                break;
                            } else {
                                continue;
                            }
                        }

                        room[nr][nc] = room[cur[0]][cur[1]] + 1;
                        Q.add(new int[]{nr, nc});
                    }
                }
            }


            // for (int[] r : room) {
            //     for (int i : r) {
            //         System.out.printf("%2d ", i);
            //     }
            //     System.out.println();
            // }
            // System.out.println();

            if (valid) answer[k] = 1;
            else answer[k] = 0;
        }


        return answer;
    }

}