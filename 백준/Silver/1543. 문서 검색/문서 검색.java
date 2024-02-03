import java.io.*;

public class Main {

    static char[] text, pattern;
    static int[] pi;
    static int cnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        text = br.readLine().toCharArray();
        pattern = br.readLine().toCharArray();
        pi = new int[pattern.length];

        getPi(pattern);
        kmp(text, pattern);

        System.out.println(cnt);
    }

    private static void getPi(char[] string) {
        int len = string.length, j = 0;
        for (int i = 1; i < len; i++){
            while (j > 0 && string[i] != string[j]) j = pi[j - 1];
            if (string[i] == string[j]) pi[i] = ++j;
        }
    }

    private static void kmp(char[] text, char[] pattern) {
        int j = 0;
        for (char c : text) {
            while (j > 0 && c != pattern[j]) j = pi[j - 1];
            if (c == pattern[j]) ++j;

            if (j == pattern.length) {
                cnt++;
                j = 0;
            }
        }
    }
}