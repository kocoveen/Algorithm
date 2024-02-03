import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char[] text, pattern;
    static int[] pi;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        text = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();
        pi = new int[pattern.length];

        getPi(pattern);
        kmp(text, pattern);


        sb.append(list.size()).append("\n");
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void getPi(char[] string) {
        int len = string.length, j = 0;
        for (int i = 1; i < len; i++){
            while (j > 0 && string[i] != string[j]) j = pi[j - 1];
            if (string[i] == string[j]) pi[i] = ++j;
        }
    }

    private static void kmp(char[] text, char[] pattern) {
        int len = text.length, j = 0;
        for (int i = 0; i < len; i++){
            while (j > 0 && text[i] != pattern[j]) j = pi[j - 1];
            if (text[i] == pattern[j]) ++j;

            if (j == pattern.length) {
                list.add((i + 1) - (j - 1));
                j = pi[j - 1];
            }
        }
    }
}