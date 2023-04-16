import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = N;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();

            if (a == 1) {
                cnt--;
                continue;
            }

            if (a == 2) continue;

            for (int j = 2; j < a; j++) {
                if (a % j == 0) {
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}