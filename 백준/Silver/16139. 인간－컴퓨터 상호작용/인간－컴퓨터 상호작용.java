import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[][] dp;
    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        int N = Integer.parseInt(br.readLine());

        dp = new int[26][S.length() + 1];

        for (int[] ints : dp)
            ints[0] = 0;

        allCount(S);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            bw.write(count(a, l, r) + "\n");
        }
        bw.flush();
    }

    public static int count(String a, int l, int r) {
        int idx = a.charAt(0) - 'a';
        return dp[idx][r + 1] - dp[idx][l];
    }

    public static void allCount(String S) {
        for (int j = 0; j < S.length(); j++) {
            char a = S.charAt(j);
            int idx = a - 'a';

            for (int i = 1; i <= S.length(); i++) {
                if (S.charAt(i - 1) == a) {
                    dp[idx][i] = dp[idx][i - 1] + 1;
                    continue;
                }
                dp[idx][i] = dp[idx][i - 1];
            }
        }
    }
}