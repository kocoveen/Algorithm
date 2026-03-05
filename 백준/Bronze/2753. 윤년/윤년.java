import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(getYear(n));
    }

    private static int getYear(int y) {
        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
            return 1;
        } else {
            return 0;
        }
    }
}