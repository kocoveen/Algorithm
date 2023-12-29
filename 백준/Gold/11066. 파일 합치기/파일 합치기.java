public class Main {

    static int t, k;
    static int[] A, S;
    static int[][] D;

    public static void main(String[] args) throws Exception {
        t = read();
        while (t-- > 0) {
            k = read();
            A = new int[k + 1];
            S = new int[k + 1];
            D = new int[k + 1][k + 1];
            for (int i = 1; i <= k; i++) {
                A[i] = read();
                S[i] = A[i] + S[i-1];
            }

            for (int gap = 1; gap <= k; gap++) {
                for (int st = 1; st + gap <= k; st++) {
                    int en = st + gap;
                    D[st][en] = Integer.MAX_VALUE;
                    for (int mid = st; mid < en; mid++) {
                        D[st][en] = Math.min(D[st][en], D[st][mid] + D[mid + 1][en] + S[en] - S[st - 1]);
                    }
                }
            }
            System.out.println(D[1][k]);
        }
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}