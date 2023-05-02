import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine());

        int total = 0;
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            a *= a;
            total += a;
        }
        System.out.println(total % 10);

    }
}