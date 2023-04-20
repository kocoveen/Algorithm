import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(combination(n, r)).append('\n');
        }
        System.out.println(sb);
    }
    private static int combination(int n, int r) {
        if(memo[n][r] > 0)
            return memo[n][r];
        if(n == r || r == 0)
            return memo[n][r] = 1;
        return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
    }
}