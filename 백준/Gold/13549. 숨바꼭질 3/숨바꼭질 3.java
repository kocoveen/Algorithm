import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, K;
    static int MIN = 0, MAX = 100001;

    static int[] time = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arrays.fill(time, -1);

        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(N);
        time[N] = 0;
        while (!Q.isEmpty()) {
            int cur = Q.remove();
            int t = time[cur];
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = cur * 2;
                    if (!isInBoundary(nx)) continue;
                    if (time[nx] > -1) continue;
                    Q.add(nx);
                    time[nx] = t;
                } else {
                    if (i == 1) nx = cur - 1;
                    else nx = cur + 1;
                    if (!isInBoundary(nx)) continue;
                    if (time[nx] > -1) continue;
                    Q.add(nx);
                    time[nx] = t + 1;
                }
            }
        }
        System.out.println(time[K]);
    }

    private static boolean isInBoundary(int i) {
        return i >= MIN && i < MAX;
    }
}
