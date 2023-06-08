import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int N, K;

    static int[] arr = new int[100001];
    static int[] pre = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        K = Integer.parseInt(l[1]);

        Arrays.fill(arr, -1);
        pre[N] = -1;

        Queue<Integer> Q = new ArrayDeque<>();
        Q.add(N);
        arr[N] = 0;

        while (!Q.isEmpty()) {
            int cur = Q.remove();
            for (int i = 0; i < 3; i++) {
                int nx = move(cur, i);
                if (nx < 0 || nx > 100000) continue;
                if (arr[nx] != -1) continue;
                if (nx == K) {
                    arr[nx] = arr[cur] + 1;
                    pre[nx] = cur;
                    break;
                }
                Q.add(nx);
                arr[nx] = arr[cur] + 1;
                pre[nx] = cur;
            }
        }

        sb.append(arr[K]).append('\n');

        Deque<Integer> D = new ArrayDeque<>();
        D.addFirst(K);
        while (D.peekFirst() != N) D.addFirst(pre[D.peekFirst()]);
        while (!D.isEmpty()) sb.append(D.removeFirst()).append(' ');

        System.out.println(sb);
    }

    private static int move(int pos, int i) {
        if (i == 0) return pos + 1;
        if (i == 1) return pos - 1;
        return pos * 2;
    }
}