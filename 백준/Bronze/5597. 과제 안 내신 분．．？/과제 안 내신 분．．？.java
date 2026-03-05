public class Main {

    static int submitStatus;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 28; i++) {
            int n = read();
            submitStatus |= (1 << n);
        }

        int allPresent = 0x7FFFFFFE;
        int missing = allPresent & ~submitStatus;

        int first = Integer.numberOfTrailingZeros(missing);
        System.out.println(first);

        int second = 31 - Integer.numberOfLeadingZeros(missing);
        System.out.println(second);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}