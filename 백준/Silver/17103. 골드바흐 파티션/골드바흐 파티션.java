import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[1000000];
        int size = 0;
        for (int j = 2; j < 1000000; j++)
            if (isPrime(j))
                arr[size++] = j;

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 0; arr[j] <= n / 2; j++)
                if (isPrime(n - arr[j])) {
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