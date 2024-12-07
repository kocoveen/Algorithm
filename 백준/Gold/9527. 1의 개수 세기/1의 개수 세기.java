import java.util.Arrays;

public class Main {

    static long[] oneSumByTwoPower;

    public static void main(String[] args) throws Exception {
        long A = read(), B = read();

        oneSumByTwoPower = new long[61];
        oneSumByTwoPower[0] = 1;

        for (int i = 1; i <= 60; i++) {
            oneSumByTwoPower[i] = (1L << i) + 2 * oneSumByTwoPower[i - 1];
        }
        System.out.println(getOneSum(B) - getOneSum(A-1));
    }

    private static long getOneSum(long l) {
        if (l == 0) return 0;
        if (l == 1) return 1;

        long k = Long.highestOneBit(l);
        long n = l - k; // 차이

        return n + 1 + oneSumByTwoPower[log2(k)-1] + getOneSum(n);
    }

    private static int log2(long n) {
        return (int) (Math.log10(n) / Math.log10(2));
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) { n = (n << 3) + (n << 1) + (c & 15); }
        return n;
    }
}