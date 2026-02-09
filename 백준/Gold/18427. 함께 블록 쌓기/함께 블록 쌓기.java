
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N, M, H;
    static int C = 10007;
    static List<Integer>[] blocks;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line1 = reader.readLine().split(" ");

        N = Integer.parseInt(line1[0]);
        M = Integer.parseInt(line1[1]);
        H = Integer.parseInt(line1[2]);

        blocks = new List[N];
        for (int i = 0; i < N; i++) {
            blocks[i] = new ArrayList<>();
            String[] line = reader.readLine().split(" ");
            for (String j : line) {
                blocks[i].add(Integer.valueOf(j));
            }
        }

        dp = new Integer[N+1][H+1];

        System.out.println(dp(N, H));
    }

    private static int dp(int n, int h) {
        if (h == 0) return 1;
        if (n <= 0 || h < 0) return 0;
        if (dp[n][h] != null) return dp[n][h];
        
        // N 번째 사람 선택하지 않기
        int result = dp(n-1, h) % C;

        // N 번째 사람 선택하기
        for (int block : blocks[n-1]) {
            result = (result + dp(n-1, h-block)) % C;
        }
        return dp[n][h] = result;
    }
}