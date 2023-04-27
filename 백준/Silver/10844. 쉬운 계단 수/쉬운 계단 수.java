import java.io.*;

public class Main {
    static Long[][] dp;
    static int N;
    static long sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new Long[N+1][10];

        for (int i = 0; i <= 9; i++)
            dp[1][i] = 1L;

        for (int i = 1; i <= 9; i++)
            sum += findMax(N, i);

        bw.write(sum % 1000000000L + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long findMax(int N, int index) {
        if (dp[N][index] == null) {
            if (index == 0)
                return dp[N][index] = findMax(N - 1, index + 1);

            if (index == 9)
                return dp[N][index] = findMax(N - 1, index - 1);

            dp[N][index] = findMax(N - 1, index - 1) + findMax(N - 1, index + 1);
        }
        return dp[N][index] % 1000000000L;
    }
}