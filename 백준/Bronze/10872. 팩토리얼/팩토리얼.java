import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = 1;
        for (int i = 2; i <= N; i++) {
            result *= i;
        }

        bw.write( result + "");
        bw.flush();
        br.close();
        bw.close();
    }
}