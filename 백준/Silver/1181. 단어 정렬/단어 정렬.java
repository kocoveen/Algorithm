import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int N;

    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        words = new String[N];

        for (int i = 0; i < N; i++) words[i] = br.readLine();

        Arrays.sort(words, (o1, o2) -> {
            if (o1.length() == o2.length()) return o1.compareTo(o2);
            else return o1.length() - o2.length();
        });

        sb.append(words[0]).append('\n');
        for (int i = 1; i < N; i++) {
            if (words[i - 1].equals(words[i])) continue;
            sb.append(words[i]).append('\n');
        }
        System.out.print(sb);
    }
}