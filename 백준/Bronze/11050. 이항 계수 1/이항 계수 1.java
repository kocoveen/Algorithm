import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = binomialCoefficient(N, K);

        bw.write( result + "");
        bw.flush();
        br.close();
        bw.close();
    }

    private static int binomialCoefficient(int n, int k) {
        int result = 1;
        int r = Math.max(n - k, k);
        for (int i = n; i > r; i--) {
            result *= i;
        }
        for (int i = 2; i <= n - r; i++) {
            result /= i;
        }
        return result;
    }
}