import java.util.Arrays;

public class Main {

    static int t, n;
    static int[] tmp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        t = read();
        while (t-- > 0) {
            n = read();
            tmp = new int[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = read();
            }
            Arrays.sort(tmp);

            arr = new int[n];
            for (int k = 0, i = 0, j = n - 1; i < j; k += 2, i++, j--) {
                arr[i] = tmp[k];
                arr[j] = tmp[k + 1];
            }
            arr[arr.length / 2] = tmp[tmp.length - 1];

            int d = findMaxDiff(arr);

            System.out.println(d);
        }
    }

    static int findMaxDiff(int[] arr) {
        int d = 0;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            d = Math.max(d, Math.abs(arr[i] - arr[(i + 1) % len]));
        }
        return d;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}