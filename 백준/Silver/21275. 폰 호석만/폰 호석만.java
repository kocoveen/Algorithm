import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.next();
        String b = scanner.next();

        int count = 0;
        for (int i = 2; i <= 36; i++) {
            try {
                long n = Long.parseLong(a, i);
                for (int j = 2; j <= 36; j++) {
                    if (i == j) continue;
                    try {
                        long m = Long.parseLong(b, j);
                        if (count == 0 && n == m) {
                            System.out.println("%d %d %d".formatted(m, i, j));
                        }
                        count++;
                    } catch (NumberFormatException e) { }
                }
            } catch (NumberFormatException e) { }
        }

        if (count > 1) {
            System.out.println("Multiple");
        } else if (count == 0) {
            System.out.println("Impossible");
        }
    }
}