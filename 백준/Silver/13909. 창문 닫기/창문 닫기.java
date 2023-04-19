import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1, n = 1; i <= N; i += 2 * n + 1, n++)
            count++;
        bw.write(count + "");
        bw.flush();
        br.close();
        bw.close();
    }
}