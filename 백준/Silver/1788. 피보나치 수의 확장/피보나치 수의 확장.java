import java.io.*;

public class Main {
    static String[] l;

    static int N, absN, sign;
    static int C = 1000000000;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        absN = Math.abs(N);
        dp = new int[absN + 1];

        dp[0] = 0;
        if (absN >= 1) dp[1] = 1;

        sign = signGenerator(N);
        for (int i = 2; i <= absN; i++) {
            dp[i] = (dp[i - 1] % C + dp[i - 2] % C) % C;
        }

        System.out.println(sign);
        System.out.println(dp[absN]);
    }

    private static int signGenerator(int n) {
        if (n == 0) return 0;
        else if (n < 0 && n % 2 == 0) return -1;
        return 1;
    }
}