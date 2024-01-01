public class Main {

    public static void main(String[] args) throws Exception {
        long x = read();
        long y = read();
        long z = y * 100 / x;

        System.out.println(lowerBound(x, y,z + 1));
    }

    private static long lowerBound(long x, long y, long t) {
        long l = 1, r = 1_000_000_001, m;
        while (l < r) {
            m = (l + r) / 2;
            if (getWinRate(x, y, m) >= t) r = m;
            else l = m + 1;
        }

        if (r != 1_000_000_001) {
            return l;
        }
        return -1;
    }

    private static long getWinRate(long x, long y, long m) {
        return (y + m) * 100 / (x + m);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}