public class Main {
    public static void main(String[] args) throws Exception {
        int N = read();
        int M = read();

        int sum = 0;
        int min = Integer.MAX_VALUE;

        Loop1:
        for (int i = N; i <= M; i++) {
            if (i == 1) continue;


            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue Loop1;
                }
            }
            sum += i;
            if (min == Integer.MAX_VALUE) {
                min = i;
            }
        }

        if (sum > 0) {
            System.out.print("%d\n%d".formatted(sum, min));
        } else {
            System.out.print(-1);
        }
    }

    public static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}