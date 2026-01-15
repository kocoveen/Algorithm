import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[] arr = new int[N];
        for (int i = N-1; i >= 0; i--) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (K < arr[i]) {
                continue;
            }
            count += K / arr[i];
            K %= arr[i];
        }
        System.out.println(count);
    }
}