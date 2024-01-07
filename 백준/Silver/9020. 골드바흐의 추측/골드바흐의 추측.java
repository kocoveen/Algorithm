public class Main {

    static final int C = 10000;
    static boolean[] isPrime = new boolean[C + 1];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i <= C; i++) {
            isPrime[i] = true;
        }

        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= C; i++) {
            for (int j = i * i; j <= C; j += i) {
                isPrime[j] = false;
            }
        }

        int t = read();
        while (t-- > 0) {
            int n = read();
            int[] pair = getPair(n);
            System.out.println(pair[0] + " " + pair[1]);
        }
    }

    private static int[] getPair(int n) {
        int l = n / 2, r = n / 2;

        while (2 <= l && r <= n) {
            while ((2 <= l) && !isPrime[l]) l--;
            while ((r <= n) && !isPrime[r]) r++;

            if (l + r > n) {
                l--;
            } else if (l + r < n) {
                r++;
            } else {
                return new int[]{l, r};
            }
        }
        return new int[]{};
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}