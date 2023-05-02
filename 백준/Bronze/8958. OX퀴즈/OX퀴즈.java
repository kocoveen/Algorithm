import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int count = 0;
            int score = 0;
            for (int j = 0; j < line.length(); j++) {
                char ans = line.charAt(j);
                if (ans == 'O') {
                    count++;
                    score += count;
                } else count = 0;
            }
            System.out.println(score);
        }
    }
}