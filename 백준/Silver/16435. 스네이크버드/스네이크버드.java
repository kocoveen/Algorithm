import java.io.*;
import java.util.Arrays;

public class Main {

    static String[] st;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int l = Integer.parseInt(st[1]);

        fruits = new int[n];
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(fruits);

        for (int fruit : fruits) {
            if (l < fruit) {
                break;
            }
            l++;
        }

        bw.write(l + "");
        bw.flush();
    }
}