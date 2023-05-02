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

        long P = factorial(N);
        long Q = factorial(K) * factorial(N - K) % R;

        System.out.println(P * pow(Q, R - 2) % R);
    }

    public static long factorial(long N) {
        long fac = 1L;

        while (N > 1) {
            fac = (fac * N) % R;
            N--;
        }
        return fac;
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