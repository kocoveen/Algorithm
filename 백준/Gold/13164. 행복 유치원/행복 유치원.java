import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] arr = new int[N];
        int[] diff = new int[N-1];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(diff);

        for (int i = 0; i < N-1; i++) {
            diff[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < N-K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}