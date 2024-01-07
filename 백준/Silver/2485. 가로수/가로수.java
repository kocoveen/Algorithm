import java.util.Arrays;

public class Main {

    static int n;
    static int[] map, diff;

    public static void main(String[] args) throws Exception {
        n = read();
        map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = read();
        }

        Arrays.sort(map);

        diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = map[i] - map[i - 1];
        }

        int g = diff[1];
        for (int i = 1; i < n; i++) {
            g = gcd(g, diff[i]);
        }

        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += (diff[i] / g - 1);
        }
        System.out.println(sum);
    }

    private static int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}