import java.util.*;

public class Main {

    static long p, cnt;
    static boolean[] isCorrect;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        isCorrect = new boolean[(int) (max - min + 1)];
        for (long l = 2; l * l <= max; l++) {
            p = (min / (l * l));
            if (min % (l * l) == 0) p--;
            for (long k = (l * l) * (p + 1); k <= max; k += l * l) {
                isCorrect[(int) (k - min)] = true;
            }
        }

        for (int n = 0; n <= max - min; n++) {
            if (!isCorrect[n]) cnt++;
        }
        System.out.println(cnt);
    }
}