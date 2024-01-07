import java.util.Arrays;

public class Main {

    static int n, m, count;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        n = read();
        m = read();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
        }
        Arrays.sort(arr);

        int l = 0, r = n - 1;
        while (l < r) {
            if (arr[l] + arr[r] < m) {
                l++;
            } else if (arr[l] + arr[r] > m) {
                r--;
            } else {
                count++;
                l++;
                r--;
            }
        }
        System.out.println(count);

    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13) System.in.read();
        return n;
    }
}