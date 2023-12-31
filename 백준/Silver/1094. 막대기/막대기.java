public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int count = 0;
        for (int i = 0; i < 7; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        System.out.println(count);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}