import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(power(A, B, C) % C);
    }

    public static long power(int A, int B, int C) {
        if (B == 1)
            return A;

        if (B % 2 == 0) {
            long tmp = power(A, B / 2, C);
            return (tmp * tmp) % C;
        } else {
            long tmp = (power(A, (B - 1) / 2, C));
            return (tmp % C * tmp % C * A % C) % C;
        }
    }

}