import java.io.*;
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


        if (A < B) {
            sb.append(B - A - 1).append("\n");
            for (int i = A + 1; i < B; i++)
                sb.append(i).append(" ");
        } else if (B < A) {
            sb.append(A - B - 1).append("\n");
            for (int i = B + 1; i < A; i++)
                sb.append(i).append(" ");
        } else {
            sb.append(0);
        }

        bw.write(sb + "");

        bw.flush();
        br.close();
        bw.close();
    }
}