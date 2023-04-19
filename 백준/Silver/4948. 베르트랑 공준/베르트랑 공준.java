import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;
            int count = 0;
            for (int i = n+1; i <= 2*n; i++) {
                if (isPrime(i))
                    count++;
            }
            sb.append(count).append("\n");
        }
        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}