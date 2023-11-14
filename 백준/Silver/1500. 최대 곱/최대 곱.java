import java.io.*;
import java.util.Arrays;

public class Main {

    static String[] st;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = br.readLine().split(" ");
        int s = Integer.parseInt(st[0]);
        int k = Integer.parseInt(st[1]);

        int n = s / k;
        int m = s % k;
        arr = new int[k];
        Arrays.fill(arr, n);
        for (int i = 0; i < m; i++) {
            arr[i]++;
        }

        long answer = 1;
        for (int i = 0; i < k; i++) {
            answer *= arr[i];
        }

        System.out.println(answer);
    }
}