import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, s, a;
    static int[] A;
    static boolean[] V;
    static int[] dx = {-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        A = new int[n + 1];
        V = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        s = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        a++;
        V[s] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int x : dx) {
                int nx = cur + x * A[cur];
                if (nx < 1 || nx > n) continue;
                if (V[nx]) continue;
                q.add(nx);
                V[nx] = true;
                a++;
            }
        }
        System.out.println(a);
    }
}