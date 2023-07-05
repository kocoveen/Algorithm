import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] primes = getPrimes(n);
        int[] dp = new int[primes.length + 1];

        for (int i = 1; i < dp.length; i++)
            dp[i] = dp[i - 1] + primes[i - 1];

        int en = 1, cnt = 0;
        for (int st = 0; st < dp.length; st++) {
            while (en < dp.length && dp[en] - dp[st] < n) en++;
            if (en == dp.length) break;
            if (dp[en] - dp[st] == n) cnt++;
        }
        System.out.println(cnt);
    }

    private static int[] getPrimes(int n) {
        int size = 0;
        //-----------------------------
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) continue;
            size++;
            for (int j = i + i; j <= n; j += i)
                isPrime[j] = false;
        }
        //------------------------------
        int[] primes = new int[size];
        for (int i = 0, j = 0; i <= n; i++)
            if (isPrime[i]) primes[j++] = i;
        return primes;
    }
}