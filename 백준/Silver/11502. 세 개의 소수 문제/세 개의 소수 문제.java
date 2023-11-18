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
            System.out.println(getThreePrime(k));
        }
    }

    private static String getThreePrime(int k) {
        for (int i = 2; i <= k; i++) {
            if (!sieve[i]) continue;
            sum[0] = i;
            for (int j = i; j <= k; j++) {
                if (!sieve[j]) continue;
                int tmp = k - (i + j);
                if (tmp >= j && sieve[tmp]) {
                    return i + " " + j + " " + tmp;
                }
            }
        }
        return "0";
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