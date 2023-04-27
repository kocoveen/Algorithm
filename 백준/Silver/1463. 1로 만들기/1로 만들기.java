import java.io.*;

public class Main {
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new Integer[N+1];
        dp[0] = dp[1] = 0;

        bw.write(findMax(N) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0)
                dp[N] = Math.min(findMax(N / 3), Math.min(findMax(N / 2), findMax(N - 1))) + 1;
            else if (N % 3 == 0)
                dp[N] = Math.min(findMax(N / 3), findMax(N - 1)) + 1;
            else if (N % 2 == 0)
                dp[N] = Math.min(findMax(N / 2), findMax(N - 1)) + 1;
            else
                dp[N] = findMax(N - 1) + 1;
        }
        return dp[N];
    }
}