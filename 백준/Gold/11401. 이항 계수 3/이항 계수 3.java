import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int R = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(binomialCoff(N, K));
    }

    public static long binomialCoff(long N, long K) {
        long A = 1;
        long B = 1;

        long i = N;
        long j = Math.min(K, N - K);

        while (j > 0) {
            A = (A * i) % R;
            B = (B * j) % R;
            i--; j--;
        }

        return A * pow(B, R - 2) % R;
    }
    
        public static long pow(long B, int i) {
        if (i == 1)
            return B % R;

        long tmp = pow(B, i / 2);

        if (i % 2 == 1)
            return (tmp * tmp % R) * B % R;
        return tmp * tmp % R;
    }
}