
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        List<long[]> list = new ArrayList<>();

        int count = 0;
        for (int i = 2; i <= 36; i++) {
            try {
                BigInteger n = new BigInteger(a, i);
                if (n.bitCount() >= 63) continue;
                for (int j = 2; j <= 36; j++) {
                    if (i == j) continue;
                    try {
                        BigInteger m = new BigInteger(b, j);
                        if (m.bitCount() >= 63) continue;
                        if (Objects.equals(n, m)) {
                            list.add(new long[]{n.longValue(), i, j});
                            count++;
                        }
                    } catch (NumberFormatException e) { }
                }
            } catch (NumberFormatException e) { }
        }

        if (list.isEmpty()) {
            System.out.println("Impossible");
        } else if (list.size() > 1) {
            System.out.println("Multiple");
        } else {
            long[] r = list.get(0);
            System.out.println(r[0] + " " + r[1] + " " + r[2]);
        }
    }
}