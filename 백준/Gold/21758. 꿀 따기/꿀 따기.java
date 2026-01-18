import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long[] honey = new long[N];
        long[] sum = new long[N];
        for (int i = 0; i < N; i++) {
            honey[i] = scanner.nextLong();
        }

        sum[0] = honey[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i-1] + honey[i];
        }

        long max = 0;

        // 벌(b1) - 벌(b2) - 벌통
        for (int i = 1; i < N-1; i++) {
            long b1 = sum[N-1] - honey[0] - honey[i];
            long b2 = sum[N-1] - sum[i];
            max = Math.max(max, b1 + b2);
        }

        // 벌통 - 벌(b1) - 벌(b2)
        for (int i = 1; i < N-1; i++) {
            long b1 = sum[i-1];
            long b2 = sum[N-2] - honey[i];
            max = Math.max(max, b1 + b2);
        }

        // 벌(b1) - 벌통 - 벌(b2)
        for (int i = 1; i < N-1; i++) {
            long b1 = sum[i] - honey[0];
            long b2 = sum[N-2] - sum[i-1];
            max = Math.max(max, b1 + b2);
        }

        System.out.println(max);
    }
}