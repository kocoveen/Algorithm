import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        long[][] arr = new long[t][];
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            arr[i] = new long[n];
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        for (int k = 0; k < t; k++) {
            List<Long> list = new ArrayList<>();
            for (int i = 0; i < arr[k].length - 1; i++) {
                for (int j = i + 1; j < arr[k].length; j++) {
                    list.add(gcd(arr[k][i], arr[k][j]));
                }
            }
            long sum = list.stream().mapToLong(Long::longValue).sum();
            System.out.println(sum);
        }
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}