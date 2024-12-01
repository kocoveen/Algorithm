public class Main {

    static int M, N;
    static int[] tmp;

    public static void main(String[] args) throws Exception {
        M = read(); N = read();
        tmp = new int[2 * M - 1];

        for (int day = 0; day < N; day++) {
            int zero = read();
            int one = read();
            int two = read();

            for (int i = zero; i < zero + one; i++) {
                tmp[i] += 1;
            }

            for (int i = zero + one; i < tmp.length; i++) {
                tmp[i] += 2;
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (j == 0) { System.out.print(tmp[M - 1 - i] + 1 + " "); }
                else { System.out.print(tmp[M + j - 1] + 1 + " "); }
            }
            System.out.println();
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}