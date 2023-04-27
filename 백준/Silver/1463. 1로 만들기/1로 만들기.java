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

        bw.write(findMax(N, 0) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int findMax(int N, int count) {
        if (N < 2)
            return count;
        return Math.min(findMax(N / 2, count + 1 + (N % 2)), findMax(N / 3, count + 1 + (N % 3)));
    }
}