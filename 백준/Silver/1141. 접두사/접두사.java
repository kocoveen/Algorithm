import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }
        Arrays.sort(words, (w1, w2) -> w2.length() - w1.length());

        HashSet<String> S = new HashSet<>();
        for (String word : words) {
            if (S.isEmpty()) {
                S.add(word);
                continue;
            }

            boolean isPrefix = false;
            for (String inWord : S) {
                if (inWord.startsWith(word)) {
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) {
                S.add(word);
            }
        }
        System.out.println(S.size());
    }
}