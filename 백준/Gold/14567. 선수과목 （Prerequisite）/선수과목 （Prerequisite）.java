import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M;
    static List<Integer>[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        arr = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int index = sc.nextInt();
            int value = sc.nextInt(); 
            arr[value].add(index);
        }

        dp = new Integer[N+1];
        for (int i = 1; i <= N; i++) {
            dp(i);
        }
        

        for (int i = 1; i <= N; i++) {
            System.out.printf("%d ", dp[i]);
        }
    }

    private static int dp(int i) {
        if (arr[i].isEmpty()) return dp[i] = 1;
        if (dp[i] != null) return dp[i];

        int max = 0;
        for (int value : arr[i]) {
            max = Math.max(max, dp(value));
        }
        return dp[i] = max + 1;
    }
}