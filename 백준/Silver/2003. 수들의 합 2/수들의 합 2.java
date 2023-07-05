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

        int en = 1, cnt = 0;
        for (int st = 0; st <= n; st++) {
            while (en <= n && a[en] - a[st] < m) en++;
            if (en > n) break;
            if (a[en] - a[st] == m) cnt++;
        }
        System.out.println(cnt);
    }
}