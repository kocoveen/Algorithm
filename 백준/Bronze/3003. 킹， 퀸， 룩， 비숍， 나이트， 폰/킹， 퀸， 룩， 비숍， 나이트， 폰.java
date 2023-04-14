import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int correct[] = {1, 1, 2, 2, 2, 8};
        for (int i : correct) {
            int h = Integer.parseInt(st.nextToken());
            bw.write(i - h + " ");
        }


        br.close();
        bw.flush();
        bw.close();
    }
}