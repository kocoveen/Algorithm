import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int N = sc.nextInt();
            if (N == -1) break;
            int a[] = new int[N];

            int sum = 0; int j = 0;
            for (int i = 1; i <= N / 2; i++) {
                if (N % i == 0) {
                    sum += i;
                    a[j++] = i;
                }
            }

            System.out.print(N);
            if (sum == N) {
                System.out.print(" = ");
                for (int k = 0; k < j-1; k++)
                    System.out.printf("%d + ", a[k]);
                System.out.printf("%d", a[j-1]);
            } else
                System.out.print(" is NOT perfect.");
            System.out.println();
        }
    }
}