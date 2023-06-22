import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static long A, B, cnt;

    static boolean[] state;
    static List<Integer> prime = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        l = br.readLine().split(" ");
        A = Long.parseLong(l[0]);
        B = Long.parseLong(l[1]);

        sieve(10000000);
        for (Integer p : prime) {
            for (long i = p; i <= B / p; i *= p) {
                cnt += (i * p >= A ? 1 : 0);
            }
        }

        System.out.println(cnt);

    }

    private static void sieve(int n) {
        state = new boolean[n + 1];
        Arrays.fill(state, true);
        for (int i = 2; i <= n; i++) {
            if (!state[i]) continue;
            for (long j = (long) i * i; j <= n; j += i) {
                state[(int) j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (state[i]) prime.add(i);
        }
    }
}