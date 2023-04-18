import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words, (w1, w2) -> {
            if (w1.length() == w2.length())
                return w1.compareTo(w2);
            else
                return w1.length() - w2.length();
        });

        bw.write(words[0] + "\n");
        for (int i = 1; i < N; i++) {
            if (!words[i].equals(words[i-1]))
                bw.write(words[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}