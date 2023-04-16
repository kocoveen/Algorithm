import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int a[] = new int[N];

        if (N == 0) {
            System.out.println(0);
            return;
        }

        int j = 0;
        for (int i = 1; i <= N/2; i++) {
            if (N % i == 0) {
                a[j++] = i;
            }
        }
        a[j] = N;

        System.out.println(a[K-1]);
    }
}