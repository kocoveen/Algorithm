import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        while (!isPalindrome(n) || isNotPrime(n)) {
            n++;
        }
        System.out.println(n);
    }

    private static boolean isPalindrome(int n) {
        char[] num = String.valueOf(n).toCharArray();
        
        int f = 0;
        int l = num.length - 1;

        while (l > 0 && f < num.length - 1 && f != l) {
            if (num[f] != num[l]) return false;
            f++;
            l--;
        }
        return true;
    }

    private static boolean isNotPrime(int n) {
        if (n == 1) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return true;
            }
        }
        return false;
    }
}