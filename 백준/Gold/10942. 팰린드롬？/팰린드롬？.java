
public class Main {

    static int n, m;
    static int[] arr;
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {
        n = read();

        arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = read();
        }

        dp = new Integer[n+1][n+1];

        int t = read();

        StringBuilder sb = new StringBuilder(); // 출력 모으기
        while (t-- > 0) {
            int i = read();
            int j = read();

            sb.append(dp(i, j)).append("\n");
        }
        System.out.print(sb);
    }

    private static int dp(int i, int j) {
        if (i >= j) {
            return dp[i][j] = 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        return dp[i][j] = arr[i] == arr[j] ? dp(i+1, j-1) : 0;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n; 
    }
}