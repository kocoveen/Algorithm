public class Main {
    static int N, mx;
    static int[] fruits;

    public static void main(String[] args) throws Exception {
        N = read();
        fruits = new int[N];
        for (int i = 0; i < N; i++) {
            fruits[i] = read();
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                int count = 0;
                int tmpMx = 0;
                for (int n = 0; n < N; n++) {
                    if (fruits[n] != i && fruits[n] != j) {
                        count = 0;
                        continue;
                    }
                    tmpMx = Math.max(tmpMx, ++count);
                }
                mx = Math.max(tmpMx, mx);
            }
        }
        System.out.println(mx);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}