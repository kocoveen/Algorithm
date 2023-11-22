import java.io.*;

public class Main {

    static String[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(":");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);

        int gcb = gcb(n, m);
        System.out.println(n / gcb + ":" + m / gcb);
    }

    private static int gcb(int n, int m) {
        if (m == 0) return n;
        return gcb(m, n % m);
    }
}