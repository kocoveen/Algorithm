import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int[] Floor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Floor = new int[F + 1];

        Arrays.fill(Floor, -1);

        Queue<Integer> Q = new ArrayDeque<>();
        Floor[S] = 0;
        Q.add(S);

        while (!Q.isEmpty()) {
            int cur = Q.remove();
            for (int go : new int[] {cur + U, cur - D}) {
                if (go > F || go < 1 || Floor[go] != -1) continue;
                Floor[go] = Floor[cur] + 1;
                Q.add(go);
            }
        }
        if (Floor[G] == -1)
            System.out.println("use the stairs");
        else
            System.out.println(Floor[G]);
    }
}