import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = read();
        Arrays.sort(arr);

        int l = 0, r = n - 1, a1 = 1000000001, a2 = 1000000001;
        while (l < r) {
            if (Math.abs(a1 + a2) > Math.abs(arr[l] + arr[r])) {
                a1 = arr[l];
                a2 = arr[r];
            }

            if (Math.abs(arr[l] + arr[r - 1]) < Math.abs(arr[l + 1] + arr[r])) r--;
            else l++;
        }
        System.out.println(a1 + " " + a2);
    }

    private static int read() throws IOException {
        int c, n = System.in.read() & 15;
        boolean isNegative = n == 13;
        if (isNegative) n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return isNegative ? ~n + 1 : n;
    }
}