import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        boolean[] sieve = eratosthenes(1000000);

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 2; j <= n / 2; j++)
                if (!sieve[j] && !sieve[n - j]) count++;
            sb.append(count).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
    private static boolean[] eratosthenes(int n) {
        boolean[] A = new boolean[n + 1];
        A[0] = A[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (!A[i])
                for (int j = i * i; j <= n; j+=i)
                    if (!A[j])
                        A[j] = true;
        return A;
    }
}