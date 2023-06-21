import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static String[] l;

    static int t, n;
    static long sum;

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            sum = 0;
            l = br.readLine().split(" ");
            n = Integer.parseInt(l[0]);
            arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(l[i + 1]);
            }

            for (int i = 0; i < n - 1; i++)
                for (int j = i + 1; j < n; j++)
                    sum += gcd(arr[i], arr[j]);

            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}