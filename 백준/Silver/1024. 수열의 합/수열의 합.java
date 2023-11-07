import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static String[] split;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        split = br.readLine().split(" ");
        long n = Long.parseLong(split[0]);
        long l = Long.parseLong(split[1]);

        // i = (l^2 + l + 2n) / 2l
        // j = (-l^2 - l + 2n) / 2l;


        for (long a = l; a <= 100; a++) {
            long j = (a - a * a + 2 * n) / (2 * a);
            long i = (a * a - a + 2 * n) / (2 * a);

            if (i - j + 1 < l || j < 0) {
                break;
            }

            long answer = 0;
            for (long k = j; k <= i; k++) {
                answer += k;
            }

            if (answer == n) {
                print(j, i);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }

    public static void print(long j, long i) {
        StringBuilder sb = new StringBuilder();
        for (long k = j; k <= i; k++) {
            sb.append(k).append(" ");
        }
        System.out.println(sb);
    }
}