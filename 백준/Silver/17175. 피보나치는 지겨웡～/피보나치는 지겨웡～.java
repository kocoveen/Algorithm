public class Main {

    static final int C = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        int n = read();

        int[] FCount = new int[51];
        FCount[0] = 1;
        FCount[1] = 1;
        for (int i = 2; i <= n; i++) {
            FCount[i] = FCount[i - 1] % C + FCount[i - 2] % C + 1;
        }
        System.out.println(FCount[n] % C);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}