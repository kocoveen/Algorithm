import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] sieve = sieve(1000000);

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;

            for (int i = 2; i <= n / 2; i++)
                if(sieve[i] && sieve[n - i]) cnt++;
            sb.append(cnt).append('\n');
        }

        System.out.print(sb);
    }

    private static boolean[] sieve(int n) {
        boolean[] tmp = new boolean[n + 1];
        Arrays.fill(tmp, true);
        tmp[0] = tmp[1] = false;
        for (int i = 2; i * i <= n; i++)
            for (int j = i * i; j <= n; j += i)
                tmp[j] = false;
        return tmp;
    }
}