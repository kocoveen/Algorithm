import java.io.IOException;

public class Main {
    static int mx = 0;

    public static void main(String[] args) throws IOException {
        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            mx = Math.max(mx, arr[i]);
        }

        long liter = binarySearch(arr, k);
        System.out.println(liter);
    }

    private static long binarySearch(int[] arr, int k) {
        long l = 1, r = mx + 1, m;
        while (l < r) {
            m = (l + r) / 2;
            if (getLiter(arr, m) >= k) l = m + 1;
            else r = m;
        }
        return l - 1;
    }

    private static long getLiter(int[] arr, long m) {
        long sum = 0;
        for (int i : arr) sum += i / m;
        return sum;
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}