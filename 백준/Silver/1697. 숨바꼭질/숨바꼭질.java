import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] location = new Integer[10000000];

        Queue<Integer> L = new ArrayDeque<>();
        location[N] = 0;
        L.add(N);

        while (location[K] == null) {
            int cur = L.remove();
            for (int nx : new int[] {cur - 1, cur + 1, cur * 2}) {
                if (nx < 0 || nx > 100000) continue;
                if (location[nx] != null) continue;
                location[nx] = location[cur] + 1;
                L.add(nx);
            }
        }

        System.out.println(location[K]);
    }
}