import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int i = Integer.parseInt(br.readLine());

        for (int j = 1; j <= i; j++) {
            bw.write(" ".repeat(i-j) + "*".repeat(2*j-1) + "\n");
        }

        for (int j = i-1; j > 0; j--) {
            bw.write(" ".repeat(i-j) + "*".repeat(2*j-1));
            if (j != 0)
                bw.write("\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}