import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[31];
        for (int i = 0; i < 28; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[a] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            if (arr[i] == 0)
                bw.write(i + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}