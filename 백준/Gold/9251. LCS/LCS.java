import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int A_length = A.length;
        int B_length = B.length;

        int[][] dp = new int[A_length+ 1][B_length + 1];

        for (int i = 1; i <= A_length; i++) {
            for (int j = 1; j <= B_length; j++) {

                if (A[i - 1] == B[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);

            }
        }

        System.out.println(dp[A_length][B_length]);
    }
}