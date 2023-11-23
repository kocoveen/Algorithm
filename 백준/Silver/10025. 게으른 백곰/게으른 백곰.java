import java.io.*;

public class Main {

    static String[] st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]) * 2 + 1;

        int[] glaciers = new int[1000001];

        while (n-- > 0) {
            st = br.readLine().split(" ");
            int g = Integer.parseInt(st[0]);
            int x = Integer.parseInt(st[1]);
            glaciers[x] = g;
        }

        int sum = 0, max = 0;
        for (int i = 0; i <= 1000000; i++) {
            if(i - k >= 0) {
                sum -= glaciers[i - k];
            }
            sum += glaciers[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}