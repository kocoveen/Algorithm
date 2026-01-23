import java.util.Scanner;

public class Main {

    static Integer[] memo;
    static int C = 10007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        memo = new Integer[n+1];
        memo[0] = 1;
        memo[1] = 1;

        System.out.print(func(n));
    }

    private static int func(int n) {
        if (memo[n] != null) {
            return memo[n];
        }

        return memo[n] = (func(n-1) + 2 * func(n-2)) % C;
    }
}