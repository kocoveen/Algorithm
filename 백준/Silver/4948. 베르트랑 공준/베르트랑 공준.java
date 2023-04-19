import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] sieve = eratosthenes(123456 * 2);

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++)
                if (!sieve[i]) count++;
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