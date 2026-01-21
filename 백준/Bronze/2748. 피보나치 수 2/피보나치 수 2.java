import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long[] arr = new long[N+2];
        arr[1] = 1L;

        for (int i = 0; i < N; i++) {
            arr[i+2] = arr[i+1] + arr[i];
        }

        System.out.println(arr[N]);
    }
}