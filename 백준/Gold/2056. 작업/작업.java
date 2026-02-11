import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static int N;
    static Information[] informations;
    static Integer[] dp;

    static class Information {
        int cost;
        int[] preconditions;

        public Information(int cost, int[] values) {
            this.cost = cost;
            this.preconditions = values;

        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new Integer[N+1];
        informations = new Information[N+1];
        
        for (int i = 1; i <= N; i++) {
            int cost = sc.nextInt();
            int C = sc.nextInt();
            int[] values = new int[C];
            for (int j = 0; j < C; j++) {
                values[j] = sc.nextInt();
            }

            informations[i] = new Information(cost, values);
        }

        System.out.println(IntStream.rangeClosed(1, N)
                            .map(i -> dp(i))
                            .max()
                            .orElse(0)
                        );
    }

    private static int dp(int i) {
        if (i < 0) return 0;
        if (dp[i] != null) return dp[i];
        
        int result = 0;
        for (int precondition : informations[i].preconditions) {
            result = Math.max(result, dp(precondition));
        }

        return dp[i] = Arrays.stream(informations[i].preconditions)
                             .map(p -> dp(p))
                             .max()
                             .orElse(0)
                       + informations[i].cost;
    }
}