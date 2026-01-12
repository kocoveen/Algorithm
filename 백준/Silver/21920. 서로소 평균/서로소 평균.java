import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int x = scanner.nextInt();
        long cnt = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            if (gcd(x, arr[i]) == 1) {
                sum += arr[i];
                cnt++;
            }
        }

        System.out.println((double) sum / cnt);
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}