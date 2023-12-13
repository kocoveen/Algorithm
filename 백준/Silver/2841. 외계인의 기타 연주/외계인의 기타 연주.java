import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        List<Pair> melodies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());
            int frat = Integer.parseInt(st.nextToken());
            melodies.add(new Pair(line, frat));
        }

        int count = 0;
        Stack<Pair>[] s = new Stack[n+1];
        for (int i = 1; i <= n; i++) {
            s[i] = new Stack<>();
        }

        for (Pair melody : melodies) {
            int l = melody.line;
            while (!s[l].isEmpty() && popped(melody, s[l])) {
                s[l].pop();
                count++;
            }

            if (!s[l].isEmpty() && isaSame(melody, s[l])) {
                continue;
            }

            s[l].push(melody);
            count++;
        }
        System.out.println(count);
    }

    private static boolean isaSame(Pair melody, Stack<Pair> s) {
        return s.peek().line == melody.line && s.peek().frat == melody.frat;
    }

    private static boolean popped(Pair melody, Stack<Pair> s) {
        return s.peek().line != melody.line || s.peek().frat > melody.frat;
    }

    private static class Pair {
        int line, frat;

        public Pair(int line, int frat) {
            this.line = line;
            this.frat = frat;
        }
    }
}