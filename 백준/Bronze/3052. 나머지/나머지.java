import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = 0;
        int reminder[] = new int[42];
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            reminder[a % 42]++;
        }

        for (int i : reminder) {
            if (i != 0)
                cnt++;
        }

        bw.write(cnt + " ");

        br.close();
        bw.flush();
        bw.close();
    }
}