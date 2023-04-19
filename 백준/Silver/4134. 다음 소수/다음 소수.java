import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            long n = Long.parseLong(br.readLine());
            while (!isPrime(n))
                n++;
            sb.append(n).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isPrime(long n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;
        return true;
    }
}