public class Main {

    public static void main(String[] args) throws Exception {
        long a = read();
        long b = read();
        System.out.println("1".repeat((int) gcd(a, b)));
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return (gcd(b, a % b));
    }

    public static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}