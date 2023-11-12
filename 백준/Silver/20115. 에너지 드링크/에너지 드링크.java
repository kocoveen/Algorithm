import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static double[] arr;
    static double[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] st = br.readLine().split(" ");

        arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(st[i]);
        }
        Arrays.sort(arr);

        dp = new double[n];
        dp[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = (arr[i] / 2) + dp[i + 1];
        }
        System.out.println(dp[0]);
    }
}