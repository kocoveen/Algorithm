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

        int sum = 0;
        for (int i = N-1; i >= 0; i--) {
            if ((N-1 - i) % 3 == 2) {
                continue;
            }
            sum += arr[i];
        }
        System.out.print(sum);
    }
}