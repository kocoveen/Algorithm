import java.io.*;

public class Main {

    static int n, C = 1_000_000;
    static Integer[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new Integer[n+1][2][3];
        System.out.println(dfs(1, 0, 0));
    }

    private static int dfs(int day, int late, int absent) {
        if (late == 2 || absent == 3) return 0;
        if (day > n) return 1;

        if (dp[day][late][absent] == null) {
            int tmp = 
            (
                dfs(day + 1, late, 0) + //참석
                dfs(day + 1, late + 1, 0) + //지각
                dfs(day + 1, late, absent + 1) //불참
            ) % C; 
            
            dp[day][late][absent] = tmp;
            return tmp;
        }
        return dp[day][late][absent];
    }
}