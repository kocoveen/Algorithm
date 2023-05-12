import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] location = new Integer[10000000];

        Queue<Integer> L = new ArrayDeque<>();
        location[N] = 0;
        L.add(N);

        if (L.peek() == K) {
            System.out.println(0);
            System.exit(0);
        }

        while (!L.isEmpty()) {
            int cur = L.remove();
            for (int i = 1; i <= 3; i++) {
                int nx = operate(cur, i);
                if (nx < 0 || nx > 100000) continue;
                if (location[nx] != null) continue;

                location[nx] = location[cur] + 1;
                if (nx == K) {
                    System.out.println(location[nx]);
                    System.exit(0);
                }
                L.add(nx);

            }
        }
    }

    private static int operate(int cur, int i) {
        if (i == 1) return cur - 1;
        if (i == 2) return cur + 1;
        return cur * 2;
    }

}