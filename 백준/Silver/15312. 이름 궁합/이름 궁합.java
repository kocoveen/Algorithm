import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[] strokes = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        findChemistry(A, B);
    }

    private static void findChemistry(String a, String b) {
        int len = a.length();
        int[] dp = new int[len * 2];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            dp[idx++] = strokes[a.charAt(i) - 'A'];
            dp[idx++] = strokes[b.charAt(i) - 'A'];
        }

        int cur = len * 2;
        while (--cur >= 2) {
            for (int i = 0; i < cur; i++) {
                dp[i] = (dp[i] + dp[i+1]) % 10;
            }
        }

        System.out.println(dp[0] + "" + dp[1]);
    }
}