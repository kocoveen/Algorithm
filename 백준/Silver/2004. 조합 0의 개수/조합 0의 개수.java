import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);
        int m1 = Math.max(m, n - m);
        int m2 = Math.min(m, n - m);
        int cnt5 = 0, cnt2 = 0;

        for (int i = n - (n % 5); i > m1; i -= 5)
            cnt5 += CountNum(i, 5);

        for (int i = n - (n % 2); i > m1; i -= 2)
            cnt2 += CountNum(i, 2);

        for (int i = m2 - (m2 % 5); i > 0; i -= 5)
            cnt5 -= CountNum(i, 5);

        for (int i = m2 - (m2 % 2); i > 0; i -= 2)
            cnt2 -= CountNum(i, 2);

        System.out.println(Math.min(cnt5, cnt2));
    }

    private static int CountNum(int i, int base) {
        int cnt = 0;
        while (i % base == 0) {
            i /= base;
            cnt++;
        }
        return cnt;
    }
}