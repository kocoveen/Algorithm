import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] Num;
    static Integer[] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        Num = new int[N+1];
        dp = new Integer[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            Num[i] = Integer.parseInt(st.nextToken());

        dp[0] = 0;

        for (int i = 1; i <= N; i++)
            LIS(i);

        int max = dp[0];
        for (int i = 1; i <= N; i++)
            max = Math.max(max, dp[i]);

        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static void LIS(int index) {
        int max = dp[0];
        for (int i = 0; i < index; i++)
            if (Num[index] > Num[i] && max < dp[i])
                max = dp[i];
        dp[index] = max + 1;
    }
}