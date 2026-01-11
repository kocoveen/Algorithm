import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] nums = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if (min > nums[i]) {
                min = nums[i];
            }
        }

        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = gcd(result, nums[i]);
        }

        for (int i = 1; i <= result; i++) {
            if (result % i == 0) {
                System.out.println(i);
            }
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
