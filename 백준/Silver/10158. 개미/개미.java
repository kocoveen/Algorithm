public class Main {
    static int R, C, r, c, t;
    static int[] dr = {1, -1};
    static int[] dc = {1, -1};

    public static void main(String[] args) throws Exception {
        C = read(); R = read();
        c = read(); r = read();
        t = read();

        int remainR = t % (2 * R);
        int remainC = t % (2 * C);

        int ri = 0;
        for (int i = 0; i < remainR; i++) {
            if (r == R || r == 0) ri = (ri + 1) % 2;
            r += dr[ri % 2];
        }

        int ci = 0;
        for (int i = 0; i < remainC; i++) {
            if (c == C || c == 0) ci = (ci + 1) % 2;
            c += dc[ci];
        }

        System.out.printf("%d %d", c, r);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
