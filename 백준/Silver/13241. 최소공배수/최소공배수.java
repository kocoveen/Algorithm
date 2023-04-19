import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        sb.append(lcm(A, B)).append("\n");

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static long lcm(long A, long B) {
        return A * B / gcb(A, B);
    }

    private static long gcb(long A, long B) {
        while (B != 0) {
            long r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
}