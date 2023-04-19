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
            sb.append(lcm(A, B)).append("\n");
        }

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