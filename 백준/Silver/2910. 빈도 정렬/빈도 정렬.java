import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int N;
    static int C;

    static List<Pair> L = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        N = Integer.parseInt(l[0]);
        C = Integer.parseInt(l[0]);

        l = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(l[i]);
            boolean chk = false;
            for (Pair pair : L) {
                if (pair.num == n) {
                    chk = true;
                    pair.cnt++;
                }
            }
            if (!chk) L.add(new Pair(n, 1));
        }

        L.sort((o1, o2) -> o2.cnt - o1.cnt);

        for (Pair pair : L)
            while (pair.cnt-- > 0) sb.append(pair.num).append(' ');

        System.out.println(sb);
    }

    private static class Pair {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }
}