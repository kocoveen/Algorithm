import java.io.*;
import java.util.*;
import java.lang.Math;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int base = Integer.parseInt(st.nextToken());

        int pow = 1;
        int sum = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            if ('A' <= c && c <= 'Z') {
                sum += (c - 'A' + 10) * pow;
            } else {
                sum += (c - '0') * pow;
            }
            pow *= base;
        }
        if (sum <= 1000000000)
            bw.write("" + sum);

        br.close();
        bw.flush();
        bw.close();
    }
}