import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String l;
        while((l = br.readLine()) != null) {
            bw.write(l + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}