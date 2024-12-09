import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][][][] visited;

    // 동, 남, 서, 북
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static class Trial {
        Point R;
        Point B;
        int trialCount;
        Status status;
        Trial(Point R, Point B, int trialCount, Status status) {
            this.R = R;
            this.B = B;
            this.trialCount = trialCount;
            this.status = status;
        }

        public Trial lean(int dir) {
            int nRr = this.R.r;
            int nRc = this.R.c;
            while (true) {
                nRr += dr[dir];
                nRc += dc[dir];
                if (map[nRr][nRc] == 'O') { break; }
                if (map[nRr][nRc] == '#') {
                    nRr -= dr[dir];
                    nRc -= dc[dir];
                    break;
                }
            }

            int nBr = B.r;
            int nBc = B.c;
            while (true) {
                nBr += dr[dir];
                nBc += dc[dir];
                if (map[nBr][nBc] == 'O') { break; }
                if (map[nBr][nBc] == '#') {
                    nBr -= dr[dir];
                    nBc -= dc[dir];
                    break;
                }
            }

            if (isInHole(nBr, nBc)) { // 파란 공이 구멍에 들어갔을 때
                visited[nRr][nRc][nBr][nBc] = true;
                return new Trial(new Point(nRr, nRc), new Point(nBr, nBc), trialCount + 1, Status.FAILURE);

            } else if (isInHole(nRr, nRc)) { // 빨간 공만 구멍에 들어갔을 때
                return new Trial(new Point(nRr, nRc), new Point(nBr, nBc), trialCount + 1, Status.SUCCESS);

            }

            // 파란 공과 빨간 공 둘 다 구멍에 들어가지 않았을 때
            // 둘의 위치가 같다면, 원래 위치를 비교해 누가 기우는 방향의 앞에 있었는지 확인
            if (nRr == nBr && nRc == nBc) {
                switch (dir) {
                    case 0: {
                        if (R.c < B.c) {
                            nRr -= dr[dir];
                            nRc -= dc[dir];
                        } else {
                            nBr -= dr[dir];
                            nBc -= dc[dir];
                        }
                        break;
                    }

                    case 1: {
                        if (R.r < B.r) {
                            nRr -= dr[dir];
                            nRc -= dc[dir];
                        } else {
                            nBr -= dr[dir];
                            nBc -= dc[dir];
                        }
                        break;
                    }

                    case 2: {
                        if (R.c < B.c) {
                            nBr -= dr[dir];
                            nBc -= dc[dir];
                        } else {
                            nRr -= dr[dir];
                            nRc -= dc[dir];
                        }
                        break;
                    }

                    case 3: {
                        if (R.r < B.r) {
                            nBr -= dr[dir];
                            nBc -= dc[dir];
                        } else {
                            nRr -= dr[dir];
                            nRc -= dc[dir];
                        }
                        break;
                    }
                }
            }

            // 원래 위치와 같다면
            if (nRr == R.r && nRc == R.c && nBr == B.r && nBc == B.c) {
                return new Trial(new Point(nRr, nRc), new Point(nBr, nBc), trialCount + 1, Status.FAILURE);
            }

            return new Trial(new Point(nRr, nRc), new Point(nBr, nBc), trialCount + 1, Status.WAITING);
        }

        private boolean isInHole(int r, int c) {
            return r == hole.r && c == hole.c;
        }
    }

    enum Status {
        SUCCESS, FAILURE, WAITING;
    }

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static Point red, blue, hole;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);

        map = new char[N][M];
        visited = new boolean[10][10][10][10];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = str.charAt(j);
                if (c == 'R') {
                    red = new Point(i, j);
                    map[i][j] = '.';
                    continue;
                } else if (c == 'B') {
                    blue = new Point(i, j);
                    map[i][j] = '.';
                    continue;
                } else if (c == 'O') {
                    hole = new Point(i, j);
                }
                map[i][j] = c;
            }
        }


        Queue<Trial> q = new ArrayDeque<>();
        q.add(new Trial(red, blue, 0, Status.WAITING));
        visited[red.r][red.c][blue.r][blue.c] = true;

        while (!q.isEmpty()) {
            Trial t = q.poll();

            for (int i = 0; i < 4; i++) {
                Trial nt = t.lean(i);
                if (nt.trialCount > 10) continue;
                if (visited[nt.R.r][nt.R.c][nt.B.r][nt.B.c]) { continue; }
                if (nt.status.equals(Status.FAILURE)) { continue; }
                if (nt.status.equals(Status.SUCCESS)) {
                    System.out.println(1);
                    System.exit(0);
                }

                q.add(nt);
                visited[nt.R.r][nt.R.c][nt.B.r][nt.B.c] = true;
            }
        }

        System.out.println(0);
    }
}