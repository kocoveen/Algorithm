import java.util.Scanner;

public class Main {
    static int T, N;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0) {
            N = sc.nextInt();

            int max = -1000001;
            int min = 1000001;

            for (int i = 0; i < N; i++) {
                int t = sc.nextInt();
                if (max < t) { max = t; }
                if (min > t) { min = t; }
            }

            System.out.printf("%d %d\n", min, max);
        }
    }
}