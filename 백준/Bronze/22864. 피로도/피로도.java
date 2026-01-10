public class Main {
    public static void main(String[] args) throws Exception {
        int A = read();
        int B = read();
        int C = read();
        int M = read();

        int f = 0, t = 0, w = 0;
        while (t < 24) {
            if (f + A > M) break;
            while (f + A <= M && t < 24) {
                f += A;
                w += B;
                t++;
           }

            while (f - C >= 0 && f + A > M && t < 24) {
                f -= C;
                t++;
           }

            if (f - C < 0 && f + A > M && t < 24) {
                f = 0;
                t++;
            }
        }
        System.out.println(w);
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}