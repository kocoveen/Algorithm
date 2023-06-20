import java.io.*;

public class Main {
    static String[] l;

    static int N, K;
    static int cnt, val;

    static boolean[] E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        K = Integer.parseInt(l[1]);

        E = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (E[i]) continue;
            for (int j = i; j <= N; j += i) {
                if (!E[j]) {
                    cnt++;
                    E[j] = true;
                    val = j;
                    if (cnt == K) {
                        System.out.println(val);
                        System.exit(0);
                    }
                }
            }
        }


    }
}