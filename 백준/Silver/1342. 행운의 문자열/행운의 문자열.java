import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] counts = new int[26];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            counts[str.charAt(i) - 'a']++;
        }

        dfs(str, 0, -1);

        System.out.println(count);
    }

    private static void dfs(String str, int depth, int prev) {
        if (str.length() == depth) {
            count++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0 && prev != i) {
                counts[i]--;
                dfs(str, depth + 1, i);
                counts[i]++;
            }
        }
    }
}