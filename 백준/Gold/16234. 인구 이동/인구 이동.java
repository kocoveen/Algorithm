import java.util.*;

public class Main {
    static int N, L, R;

    static int[][] A;
    static boolean[][] V;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static List<int[]> list;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        A = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int day = 0;
        while (true) {
            boolean moved = false;
            V = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (V[i][j]) continue;
                    
                    int sum = bfs(i, j);

                    if (list.size() > 1) {
                        int avg = sum / list.size();
                        for(int[] p : list) {
                            A[p[0]][p[1]] = avg;
                        }
                        moved = true;
                    }
                }
            }

            if (!moved) {
                break;
            }
            day++;
        }

        System.out.println(day);
    }

    static int bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        list = new ArrayList<>();
        
        q.add(new int[]{r, c});
        list.add(new int[]{r, c});
        V[r][c] = true;

        int sum = A[r][c];

        while (!q.isEmpty()) {
            int[] info = q.poll();
            r = info[0];
            c = info[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                int diff = Math.abs(A[nr][nc] - A[r][c]);
                if (diff < L || R < diff) continue;
                if (V[nr][nc]) continue;

                V[nr][nc] = true;
                q.add(new int[]{nr, nc});
                list.add(new int[]{nr, nc});
                sum += A[nr][nc];
            }
        }
        return sum;
    }
}