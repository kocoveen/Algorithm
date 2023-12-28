public class Main {

    static int[] A, D;

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] A = new int[n + 1];
        int[] D = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            A[i] = read();
        }

        A[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (A[j] > A[i]) {
                    max = Math.max(max, D[j]);
                }
            }
            D[i] = max + 1;
        }

        int maxSize = 0;
        for (int i = 0; i <= n; i++) {
            maxSize = Math.max(maxSize, D[i]);
        }
        System.out.println(n - maxSize);

    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}