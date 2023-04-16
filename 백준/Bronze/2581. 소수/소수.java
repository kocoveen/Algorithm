import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int sum = 0; int min = 0;
        Loop1:
        for (int i = N; i <= M; i++) {
            if (i == 1) continue;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    continue Loop1;
            }
            if (sum == 0) min = i;
            sum += i;
        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
            return;
        }
        System.out.println(-1);
    }
}