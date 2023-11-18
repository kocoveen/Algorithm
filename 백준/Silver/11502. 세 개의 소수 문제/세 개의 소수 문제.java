import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static String[] st;
    static boolean[] sieve;
    static int[] sum = new int[3];
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            sieve = makeSieve(k);
            dfs(k, 0, 2);
            System.out.printf("%d %d %d\n", answer[0], answer[1], answer[2]);
        }
    }

    private static void dfs(int k, int depth, int st) {
        if (depth == 3) {
            int a = 0;
            for (int i = 0; i < depth; i++) {
                a += sum[i];
            }

            if (a == k) {
                answer[0] = sum[0];
                answer[1] = sum[1];
                answer[2] = sum[2];
            }
            return;
        }

        for (int i = st; i <= k; i++) {
            if (sieve[i]) {
                sum[depth] = i;
                dfs(k, depth + 1, i);
            }
        }
    }

    private static boolean[] makeSieve(int k) {
        boolean[] sieve = new boolean[k + 1];
        Arrays.fill(sieve, true);

        sieve[0] = false;
        sieve[1] = false;
        for (int i = 2; i <= Math.sqrt(k); i++) {
            for (int j = i + i; j <= k; j += i) {
                if (j % i == 0) {
                    sieve[j] = false;
                }
            }
        }
        return sieve;
    }
}