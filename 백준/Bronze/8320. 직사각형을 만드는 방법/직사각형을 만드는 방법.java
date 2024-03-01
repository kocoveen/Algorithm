import java.util.Scanner;

public class Main {

    static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i * i <= n; i++) {
            m += (n / i) - (i - 1);
        }
        System.out.println(m);
    }
}