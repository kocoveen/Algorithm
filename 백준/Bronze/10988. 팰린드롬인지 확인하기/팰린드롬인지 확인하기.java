import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int flag = 1;
        for (int i = 0; i < s.length() / 2; i++) {
            if (!s.substring(i, i+1).equals(s.substring(s.length()-i-1, s.length()-i))) {
                flag = 0;
                break;
            }
        }
        bw.write(flag + "");

        br.close();
        bw.flush();
        bw.close();
    }
}