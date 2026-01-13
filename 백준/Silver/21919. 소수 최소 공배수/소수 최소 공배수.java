import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Set<Long> set = new HashSet<>();
        while(N-- > 0) {
            long A = scanner.nextLong();
            if (!isNotPrime(A)) {
                set.add(A);
            }
        }

        if (!set.isEmpty()) {
            long sum = set.stream().reduce(1L, (subtotal, element) -> lcm(subtotal, element));
            System.out.print(sum);
        } else {
            System.out.print(-1);
        }

    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static boolean isNotPrime(long A) {
        for (long i = 2L; i * i <= A; i++) {
            if (A % i == 0) return true;
        }
        return false;
    }
}