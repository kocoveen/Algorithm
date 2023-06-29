import java.io.*;
import java.util.*;

public class Main {
    static String[] l;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l = br.readLine().split(" ");
        int m = Integer.parseInt(l[0]);
        int n = Integer.parseInt(l[1]);

        int[] snacks = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            snacks[i] = Integer.parseInt(l[i]);
            M = Math.max(M, snacks[i]);
        }

        long min = 1;
        long max = M + 1;
        long mid = (min + max) / 2;
        long key = cnt(snacks, mid);

        while (min < max) {
            if (key >= m) min = mid + 1;
            else max = mid;
            mid = (min + max) / 2;
            key = cnt(snacks, mid);
        }
        System.out.println(mid - 1);
    }

    private static long cnt(int[] snacks, long mid) {
        int sum = 0;
        for (int snack : snacks) {
            sum += snack / mid;
        }
        return sum;
    }
}