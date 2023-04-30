import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] dp;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        dp = new int[S.length() + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            System.out.println(count(a, l, r));
        }
    }

    public static int count(String a, int l, int r) {
        for (int i = 1; i <= S.length(); i++) {
            if (S.charAt(i - 1) == a.charAt(0))
                dp[i] = dp[i - 1] + 1;
            else
                dp[i] = dp[i - 1];
        }
        
        return dp[r + 1] - dp[l];
    }
}