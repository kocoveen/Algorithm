import java.io.*;

public class Main {

    static int[] num = new int[10];
    static int idx, mx = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            num[idx]++;
        }

        int sn = num[6] + num[9];
        int k = sn / 2 + sn % 2;
        num[6] = k;
        num[9] = k;

        for (int i = 0; i < 10; i++) {
            mx = Math.max(mx, num[i]);
        }

        System.out.println(mx);
    }
}