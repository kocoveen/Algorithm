import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int cnt = N;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length()-1; j++) {
                if (s.charAt(j) == s.charAt(j+1))
                    continue;
                else if (s.substring(j+1).contains(s.substring(j, j+1))) {
                    cnt--;
                    break;
                }
            }
        }
        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }
}