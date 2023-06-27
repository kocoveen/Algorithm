import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        long n = Long.parseLong(l[0]);
        long m = Long.parseLong(l[1]);

        long cnt5 = CountNum(n, 5) - CountNum(m, 5) - CountNum((n - m), 5);
        long cnt2 = CountNum(n, 2) - CountNum(m, 2) - CountNum((n - m), 2);

        System.out.println(Math.min(cnt5, cnt2));
    }

    private static long CountNum(long num, long p) {
        long cnt = 0, div = p;
        while (num / div != 0) {
            cnt += (num / div);
            div *= p;
        }
        return cnt;
    }
}