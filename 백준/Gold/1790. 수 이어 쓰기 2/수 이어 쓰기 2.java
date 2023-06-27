import java.io.*;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        l = br.readLine().split(" ");
        long n = Long.parseLong(l[0]);
        long k = Long.parseLong(l[1]);

        long len = 1, exp = 1;
        while (k > 9L * len * exp) {
            k -= 9L * len * exp;
            exp *= 10;
            len++;
        }

        long target = exp + (k - 1) / len;

        if (target > n) System.out.println(-1);
        else System.out.println(String.valueOf(target).charAt((int) ((k - 1) % len)));
    }
}