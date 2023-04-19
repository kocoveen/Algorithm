import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = 1;
            int D = 2;
            for (; D <= Math.max(Math.sqrt(Math.max(A, B)), Math.min(A, B)); D++) {
                while (A % D == 0 && B % D == 0) {
                    C *= D;
                    A /= D;
                    B /= D;
                }
            }
            C *= A * B;
            sb.append(C).append("\n");
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}