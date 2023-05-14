import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] students = new int[100005];
    static int[] state = new int[100005];

    private static final int NOT_VISITED = 0;
    private static final int VISITED = 1;
    private static final int NOT_CYCLE_IN = 2;
    private static final int CYCLE_IN = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            Arrays.fill(state, 1, n + 1, 0);
            for (int i = 1; i <= n; i++)
                students[i] = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= n; i++)
                if (state[i] == NOT_VISITED) run(i);

            int cnt = 0;
            for (int i = 1; i <= n; i++)
                if (state[i] == NOT_CYCLE_IN) cnt++;

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static void run(int x) {
        int cur = x;
        while (true) {
            state[cur] = VISITED;
            cur = students[cur];

            if (state[cur] == CYCLE_IN || state[cur] == NOT_CYCLE_IN) {
                cur = x;
                while (state[cur] == VISITED) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }

            if (cur != x && state[cur] == VISITED) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = students[cur];
                }
                cur = x;
                while (state[cur] != CYCLE_IN) {
                    state[cur] = NOT_CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }

            if (cur == x && state[cur] == VISITED) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = students[cur];
                }
                return;
            }
        }
    }
}