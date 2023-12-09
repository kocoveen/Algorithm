import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int n, m;

    static char[][] map;
    static boolean[][][][] visited;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        int[] R = new int[2];
        int[] B = new int[2];

        visited = new boolean[n][m][n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'R') {
                    R[0] = i;
                    R[1] = j;
                } else if (c == 'B') {
                    B[0] = i;
                    B[1] = j;
                }
            }
        }

        visited[R[0]][R[1]][B[0]][B[1]] = true;
        System.out.println(bfs(R, B));
    }

    private static int bfs(int[] R, int[] B) {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(R, B, 0));

        while (!q.isEmpty()) {
            Info cur = q.poll();
            if (cur.round == 10) {
                return -1;
            }
            for (int i = 0; i < 4; i++) {
                int[] nR = {cur.R[0], cur.R[1]};
                int[] nB = {cur.B[0], cur.B[1]};

                boolean isEscapeR = go(i, nR); // R 구슬 이동
                boolean isEscapeB = go(i, nB); // B 구슬 이동

                if (isEscapeB) {
                    continue;
                }

                if (isEscapeR) {
                    return cur.round + 1;
                }

                // 둘다 탈출 X && 도착 위치가 같을 경우 -> 조정 작업
                if (nR[0] == nB[0] && nR[1] == nB[1]) {
                    if (i == 0) { // 아래 기울기
                        if (cur.R[0] < cur.B[0]) {
                            nR[0] -= dr[i];
                        } else {
                            nB[0] -= dr[i];
                        }
                    } else if (i == 1) { // 오른 기울기
                        if (cur.R[1] < cur.B[1]) {
                            nR[1] -= dc[i];
                        } else {
                            nB[1] -= dc[i];
                        }
                    } else if (i == 2) { // 위 기울기
                        if (cur.R[0] < cur.B[0]) {
                            nB[0] -= dr[i];
                        } else {
                            nR[0] -= dr[i];
                        }
                    } else { // 왼 기울기
                        if (cur.R[1] < cur.B[1]) {
                            nB[1] -= dc[i];
                        } else {
                            nR[1] -= dc[i];
                        }
                    }
                }

                // 두 구슬이 이동한 상태가 처음인 경우만 이동 -> 큐에 추가
                if (!visited[nR[0]][nR[1]][nB[0]][nB[1]]) {
                    visited[nR[0]][nR[1]][nB[0]][nB[1]] = true;
                    q.add(new Info(nR, nB,cur.round + 1));
                }
            }
        }
        return -1;
    }

    private static boolean go(int i, int[] M) {
        boolean isEscape = false;
        while (map[M[0] + dr[i]][M[1] + dc[i]] != '#') {
            M[0] += dr[i];
            M[1] += dc[i];

            if (map[M[0]][M[1]] == 'O') {
                isEscape = true;
                break;
            }
        }
        return isEscape;
    }

    private static class Info {
        int[] R, B;
        int round;

        public Info(int[] R, int[] B, int round) {
            this.R = R;
            this.B = B;
            this.round = round;
        }
    }
}