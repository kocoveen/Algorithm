import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        List<List<Integer>> dots = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            dots.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            int x = read();
            int color = read();
            dots.get(color).add(x);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> p = dots.get(i);
            if (p.isEmpty() || p.size() == 1) continue;
            Collections.sort(p, (i1, i2) -> i1 - i2);
        }

        long l = 0;
        for (int i = 1; i <= n; i++) {
            List<Integer> p = dots.get(i);
            if (p.isEmpty() || p.size() == 1) {
                continue;
            }

            for (int j = 0; j < p.size(); j++) {
                if (j == 0) {
                    l += p.get(j + 1) - p.get(j);
                } else if (j == p.size() - 1) {
                    l += p.get(j) - p.get(j - 1);
                } else {
                    l += Math.min(p.get(j) - p.get(j - 1), p.get(j + 1) - p.get(j));
                }
            }
        }
        System.out.println(l);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}