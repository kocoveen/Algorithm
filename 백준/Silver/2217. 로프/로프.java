import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, arr[i] * (N - i));
        }

        System.out.println(max);

    }
}