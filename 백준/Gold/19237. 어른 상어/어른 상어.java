import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static int n, m, k;

    // 위 아래 왼 오른
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Info info = new Info(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num > 0) {
                    Shark shark = new Shark(num, i, j);
                    info.sharks.add(shark);
                    info.map[i][j] = shark;
                }
            }
        }
        Collections.sort(info.sharks, (s1, s2) -> s1.num - s2.num);

        st = new StringTokenizer(br.readLine());
        for (Shark shark : info.sharks) {
            shark.dir = Integer.parseInt(st.nextToken()) - 1;
        }

        for (Shark shark : info.sharks) {
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    shark.pri[i][j] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }
        Collections.sort(info.sharks, (s1, s2) -> s2.num - s1.num);
        info.makeSmells();

        int i = 1;
        while (i <= 1000) {
            info.moveSharks();
            info.removeShark();
            info.smellsOut();
            info.makeSmells();

            if (info.sharks.size() == 1 && info.sharks.get(0).num == 1) {
                break;
            }
            i++;
        }
        System.out.println(i > 1000 ? -1 : i);

    }

    private static class Info {
        Shark[][] map;
        Smell[][] smellMap;
        List<Shark> sharks = new ArrayList<>(); //번호가 높은 상어부터 해야 조건 만족

        public Info(int n) {
            this.map = new Shark[n][n];
            this.smellMap = new Smell[n][n];
        }

        public void moveSharks() {
            for (Shark shark : sharks) {

                boolean isMoved = false;
                for (int i = 0; i < 4; i++) {
                    int pri = shark.pri[shark.dir][i];
                    int nr = shark.r + dr[pri];
                    int nc = shark.c + dc[pri];
                    if (isOutBound(nr, nc)) continue;
                    if (smellMap[nr][nc] != null) continue;
                    map[shark.r][shark.c] = null;
                    shark.dir = pri;
                    shark.r = nr;
                    shark.c = nc;
                    isMoved = true;
                    break;
                }

                if (!isMoved) {
                    for (int i = 0; i < 4; i++) {
                        int pri = shark.pri[shark.dir][i];
                        int nr = shark.r + dr[pri];
                        int nc = shark.c + dc[pri];
                        if (isOutBound(nr, nc)) continue;
                        if (smellMap[nr][nc].num == shark.num) {
                            map[shark.r][shark.c] = null;
                            shark.dir = pri;
                            shark.r = nr;
                            shark.c = nc;
                            break;
                        }
                    }
                }
            }

            for (Shark shark : sharks) {
                map[shark.r][shark.c] = shark;
            }
        }

        public void makeSmells() {
            for (Shark shark : sharks) {
                Smell smell = shark.makeSmell();
                smellMap[shark.r][shark.c] = smell;
            }
        }

        public void removeShark() {
            sharks.removeIf(shark -> map[shark.r][shark.c].num != shark.num);
        }

        private void smellsOut() {
            for (Smell[] smells : smellMap) {
                for (Smell smell : smells) {
                    if (smell == null){
                        continue;
                    }
                    smell.k -= 1;
                    if (smell.k == 0) {
                        smellMap[smell.r][smell.c] = null;
                    }
                }
            }
        }

        private void isRunning() {

        }

        private boolean isOutBound(int nr, int nc) {
            return nr < 0 || n <= nr || nc < 0 || n <= nc;
        }
    }

    private static class Shark {
        int num; //상어 번호
        int r, c; //상어 위치

        //0, 1, 2, 3 -> 위, 아래, 왼, 오른
        int dir; //현재 보는 방향
        int[][] pri = new int[4][4];  //보는 방향에 따른 우선순위

        public Shark(int num, int r, int c) {
            this.num = num;
            this.r = r;
            this.c = c;
        }

        public Smell makeSmell() {
            return new Smell(this.num, this.r, this.c, k);
        }
    }

    private static class Smell {
        int num;
        int r, c;
        int k; //잔여 향기

        public Smell(int num, int r, int c, int k) {
            this.num = num;
            this.r = r;
            this.c = c;
            this.k = k;
        }
    }
}