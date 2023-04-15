import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int n10 = Integer.parseInt(st.nextToken());
        int base = Integer.parseInt(st.nextToken());

        char c;
        while (n10 >= 1) {
            int i = n10 % base;
            if (10 <= i && i <= 35)
                c = (char) (i + 'A' - 10);
            else
                c = (char) (i + '0');
            sb.append(c);
            n10 /= base;
        }
        sb.reverse();
        String result = sb.toString();

        bw.write(result);

        br.close();
        bw.flush();
        bw.close();
    }
}