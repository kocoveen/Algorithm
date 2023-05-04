import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    private final static long MOD = 1000000007;
    static long[][] O = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());
        long[][] A = {{1, 1}, {1, 0}};

        bw.write(power(A, N - 1)[0][0] + "");
        bw.flush();
    }

    private static long[][] power(long[][] A, long N) {
        if (N == 0 || N == 1)
            return A;

        long[][] tmp = power(A, N / 2);
        tmp = multiply(tmp, tmp);

        if (N % 2 == 1)
            return multiply(tmp, O);

        return tmp;
    }

    private static long[][] multiply(long[][] A1, long[][] A2) {
        long[][] tmp = new long[2][2];

        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    tmp[i][j] += (A1[i][k] * A2[k][j]);
                tmp[i][j] %= MOD;
            }

        return tmp;
    }

}