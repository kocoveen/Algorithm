public class Main {

    public static void main(String[] args) throws Exception {
        long a = read();
        long b = read();
        System.out.println(a * a - b * b);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}