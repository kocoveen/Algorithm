import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextLong();
        }

        Arrays.sort(arr);

        long max = 0;
        if (N % 2 != 0) {
            for (int i = 0; i < (N-1) / 2; i++) {
                max = Math.max(max, arr[i] + arr[N-2-i]);
            }
            max = Math.max(max, arr[N-1]);
        } else {
            for (int i = 0; i < N / 2; i++) {
                max = Math.max(max, arr[i] + arr[N-1-i]);
            }
        }
        System.out.println(max);
    }
}