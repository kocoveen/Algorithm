import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[][] A;
    static int[] isVisited;
    static int N;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N][N];
        isVisited = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                A[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);
        System.out.print(min);
    }

    public static void dfs(int startDepth, int startPlayer) {
        if (startDepth == N/2) {
            int diff = stat();
            if (min > diff)
                min = diff;
            if (min == 0) {
                System.out.println(min);
                System.exit(0);
            }
            return;
        }
        for (int i = startPlayer; i < N; i++) {
            if (isVisited[i] == 1) continue;
            isVisited[i] = 1;
            dfs(startDepth + 1, i + 1);
            isVisited[i] = 0;
        }
    }

    public static int stat() {
        int team_start = 0;
        int team_link = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isVisited[i] == 1 && isVisited[j] == 1) {
                    team_start += A[i][j];
                    team_start += A[j][i];
                }
                else if (isVisited[i] == 0 && isVisited[j] == 0) {
                    team_link += A[i][j];
                    team_link += A[j][i];
                }
            }
        }
        return Math.abs(team_link - team_start);
    }
}
