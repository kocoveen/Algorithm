import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();
        StringTokenizer st;


        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int E = A * D + B * C;
        int F = B * D;
        int G = gcb(E, F);

        E /= G;
        F /= G;

        sb.append(E).append(" ").append(F);

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }

    private static int lcm(int A, int B) {
        return A * B / gcb(A, B);
    }

    private static int gcb(int A, int B) {
        while (B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }
        return A;
    }
}