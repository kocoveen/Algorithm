import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static String[] tokens;
    static String line;
    static int t, n, m;
    static char[][] map;
    static boolean[][] vis;
    static boolean[] isUnlocked;
    static Queue<Info>[] doors;
    static Queue<Info> q;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            tokens = br.readLine().split(" ");
            n = Integer.parseInt(tokens[0]);
            m = Integer.parseInt(tokens[1]);
            map = new char[n][m];
            vis = new boolean[n][m];
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                line = br.readLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            isUnlocked = new boolean[26];
            String keys = br.readLine();
            if (!keys.equals("0")) {
                for (int i = 0; i < keys.length(); i++) {
                    isUnlocked[keys.charAt(i) - 'a'] = true;
                }
            }

            doors = new Queue[26];
            for (int i = 0; i < 26; i++) {
                doors[i] = new LinkedList<>();
            }

            q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (isBoundary(i, j)) {
                        if (map[i][j] == '.') {
                            q.add(new Info(i, j));
                        } else if ('a' <= map[i][j] && map[i][j] <= 'z') {
                            isUnlocked[map[i][j] - 'a'] = true;
                            q.add(new Info(i, j));
                        } else if ('A' <= map[i][j] && map[i][j] <= 'Z') {
                            doors[map[i][j] - 'A'].add(new Info(i, j));
                        } else if (map[i][j] == '$') {
                            cnt++;
                            q.add(new Info(i, j));
                        }
                        vis[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < 26; i++) {
                if (isUnlocked[i]) {
                    q.addAll(doors[i]);
                    doors[i].clear();
                }
            }

            while (!q.isEmpty()) {
                Info cur = q.remove();
                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    if (nr < 0 || n <= nr || nc < 0 || m <= nc) continue;
                    if (map[nr][nc] == '*') continue;
                    if (vis[nr][nc]) continue;

                    if ('A' <= map[nr][nc] && map[nr][nc] <= 'Z') {
                        doors[map[nr][nc] - 'A'].add(new Info(nr, nc));
                        if (isUnlocked[map[nr][nc] - 'A']) {
                            q.addAll(doors[map[nr][nc] - 'A']);
                            doors[map[nr][nc] - 'A'].clear();
                        }
                    } else if ('a' <= map[nr][nc] && map[nr][nc] <= 'z') {
                        isUnlocked[map[nr][nc] - 'a'] = true;
                        if (isUnlocked[map[nr][nc] - 'a']) {
                            q.addAll(doors[map[nr][nc] - 'a']);
                            doors[map[nr][nc] - 'a'].clear();
                        }
                        q.add(new Info(nr, nc));
                    } else if ('$' == map[nr][nc]) {
                        cnt++;
                        q.add(new Info(nr, nc));
                    } else {
                        q.add(new Info(nr, nc));
                    }
                    vis[nr][nc] = true;
                }
            }
            sb.append(cnt).append('\n');

        }
        System.out.print(sb);
    }

    private static boolean isBoundary(int i, int j) {
        return i == 0 || i == n - 1 || j == 0 || j == m - 1;
    }

    private static class Info {
        int r, c;
        public Info(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}