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
        int len = a.length() + b.length();
        int[] dp = new int[len];
        for (int i = 0; i < len; i += 2) {
            int j = i / 2;
            dp[i] = strokes[a.charAt(j) - 'A'];
            dp[i + 1] = strokes[b.charAt(j) - 'A'];
        }

        for (int i = len-1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                dp[j] = (dp[j] + dp[j+1]) % 10;
            }
        }
        System.out.println(dp[0] + "" + dp[1]);
    }
}