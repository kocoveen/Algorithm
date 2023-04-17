import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(i % 5 != 0 && i >= 3) {
            i -= 3; cnt++;
        }

        if (i == 1 || i == 2) {
            bw.write("-1");
        } else {
            cnt += i / 5;
            bw.write(cnt + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}