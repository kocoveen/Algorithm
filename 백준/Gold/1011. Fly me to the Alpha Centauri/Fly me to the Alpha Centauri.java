public class Main {
    public static void main(String[] args) throws Exception {
        int t = read();
        long a = 0;
        while (t-- > 0) {
            int x = read();
            int y = read();
            int diff = y - x;

            for (long i = 0; i < 46341; i++) {
                long p = i * i;
                long n = (i + 1) * (i + 1);

                if (p < diff && diff <= n) {
                    if (diff <= p + i) a = 2 * i;
                    else a = 2 * i + 1;
                    break;
                }
            }
            System.out.println(a);
        }
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}