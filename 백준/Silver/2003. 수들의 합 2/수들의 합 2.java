import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);

        l = br.readLine().split(" ");
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) a[i] = a[i - 1] + Integer.parseInt(l[i - 1]);

        int l = 0, r = 0, cnt = 0;
        while (r <= n) {
            int pSum = a[r] - a[l];
            if (pSum <= m) {
                if (pSum == m) cnt++;
                r++;
            }
            else l++;
        }
        System.out.println(cnt);
    }
}