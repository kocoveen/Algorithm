import java.io.*;
import java.util.Arrays;

public class Main {

    static String[] st;
    static int digit10;
    static int[] digitB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = br.readLine().split(" ");
        int a = Integer.parseInt(st[0]);
        int b = Integer.parseInt(st[1]);

        int m = Integer.parseInt(br.readLine());

        st = br.readLine().split(" ");
        int n = 1;
        for (int i = m - 1; i >= 0; i--) {
            digit10 += Integer.parseInt(st[i]) * n;
            n *= a;
        }

        int len = getDigitBLen(b, digit10);
        digitB = new int[len];
        while (len > 0) {
            digitB[--len] = digit10 % b;
            digit10 /= b;
        }

        for (int i : digitB) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }

    private static int getDigitBLen(int b, int digit10) {
        int len = 0;
        while (digit10 > 0) {
            digit10 /= b;
            len++;
        }
        return len;
    }
}