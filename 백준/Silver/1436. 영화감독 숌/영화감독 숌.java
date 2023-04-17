import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(br.readLine());
        int n = 666;
        while (true) {
            String sN = String.valueOf(n);
            int cnt = 0;
            for (int j = 0; j < sN.length() - 2; j++) {
                if (sN.charAt(j) == '6' && sN.charAt(j+1) == '6' && sN.charAt(j+2) == '6')
                    cnt++;
                if (cnt == 1)
                    break;
            }
            n++;
            if (cnt < 1)
                continue;

            i--;
            if (i == 0)
                break;
        }

        bw.write(n-1 + "");

        bw.flush();
        br.close();
        bw.close();
    }
}