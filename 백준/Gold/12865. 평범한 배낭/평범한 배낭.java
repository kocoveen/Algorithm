import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] W;
    static int[] V;
    static Integer[][] dp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];
        dp = new Integer[N][L+1];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(knapbag(N - 1, L));
    }

    public static int knapbag(int i, int k) {
        if (i < 0)
            return 0;
        if (dp[i][k] == null) {

            if (W[i] > k)
                dp[i][k] = knapbag(i - 1, k);
            else if (W[i] <= k)
                dp[i][k] = Math.max(knapbag(i - 1, k), knapbag(i - 1, k - W[i]) + V[i]);

        }
        return dp[i][k];
    }
}