import java.util.Scanner;

public class Main {

    static Integer[] num;
    static int C = 10_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        num = new Integer[N+1];
        num[0] = 1;
        num[1] = 1;

        System.out.println(solve(N));
    }

    private static int solve(int i) {
        if (i < 0) {
            return 0;
        }

        if (num[i] != null) {
            return num[i];
        }

        return num[i] = (solve(i-1) % C + solve(i-2) % C) % C;
    }
}