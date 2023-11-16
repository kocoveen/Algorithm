import java.io.*;

public class Main {

    static String[] st;
    static int[] digits = new int[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int d = Integer.parseInt(st[1]);

        for (int i = 1; i <= n; i++) {
            String string = String.valueOf(i);
            for (int j = 0; j < string.length(); j++) {
                int digit = string.charAt(j) - '0';
                digits[digit]++;
            }
        }
        System.out.println(digits[d]);
    }
}