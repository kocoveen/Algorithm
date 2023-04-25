import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int c1 = 0;
    static int c2 = 0;
    static int[] f = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        rFib(N); dFib(N);
        System.out.printf("%d %d", c1, c2);
    }

    public static int rFib(int n) {
        if (n == 1 || n == 2) {
            c1++;
            return 0;
        }
        return rFib(n - 1) + rFib(n - 2);
    }

    public static int dFib(int n) {
        f[1] = 1; f[2] = 1;
        for (int i = 3; i <= n; i++) {
            c2++;
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }
}
