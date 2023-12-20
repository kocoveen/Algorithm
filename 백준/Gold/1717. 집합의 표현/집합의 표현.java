import java.io.*;
import java.util.HashSet;

public class Main {

    static int[] sets;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = read();
        int m = read();

        sets = new int[n+1];
        for (int i = 0; i <= n; i++) {
            sets[i] = i;
        }

        while (m-- > 0) {
            int cmd = read(), a = read(), b = read();
            int r1 = find(a);
            int r2 = find(b);
            if (cmd == 1) {
                if (r1 == r2) {
                    sb.append("yes").append('\n');
                } else {
                    sb.append("no").append('\n');
                }
            } else {
                if (r1 == r2) {
                    continue;
                }
                int min = Math.min(r1, r2);
                int max = Math.max(r1, r2);
                sets[max] = min;
            }
        }
        System.out.print(sb);
    }

    static int find(int i) {
        if (sets[i] == i) return i;
        return sets[i] = find(sets[i]);
    }

    static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}