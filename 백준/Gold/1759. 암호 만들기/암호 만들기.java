import java.io.*;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int L, C;

    static boolean[] vis;
    static char[] words;
    static char[] pw;

    static char[] V = {'a', 'e', 'i', 'o', 'u'};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        L = Integer.parseInt(l[0]);
        C = Integer.parseInt(l[1]);

        pw = new char[L];
        vis = new boolean[C];
        words = new char[C];

        l = br.readLine().split(" ");
        for (int i = 0; i < C; i++) words[i] = l[i].charAt(0);

        Arrays.sort(words);

        func(0, 0, 0, 0);
    }

    private static void func(int depth, int con, int vow, int s) {
        if (depth == L) {
            if (con >= 2 && vow >= 1) {
                for (char c : pw)
                    System.out.printf("%c", c);
                System.out.println();
            }
            return;
        }

        for (int i = s; i < C; i++) {
            if (vis[i]) continue;
            char c = words[i];
            pw[depth] = c;
            vis[i] = true;
            func(depth + 1, con + consonant(c), vow + vowel(c), i + 1);
            vis[i] = false;
        }
    }

    private static int consonant(char c) {
        for (char value : V) if (value == c) return 0;
        return 1;
    }

    private static int vowel(char c) {
        for (char value : V) if (value == c) return 1;
        return 0;
    }
}