import java.io.*;

public class Main {
    static String[] l;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int m = Integer.parseInt(l[1]);

        int[] trees = new int[n];
        l = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(l[i]);
            M = Math.max(M, trees[i]);
        }

        long min = 0;
        long max = M;
        long mid;
        long key;

        while (min < max) {
            mid = (min + max) / 2;
            key = cnt(trees, mid);

            if (key < m)
                max = mid;
            else if (key >= m)
                min = mid + 1;
        }
        System.out.println(max - 1);
    }

    private static long cnt(int[] trees, long mid) {
        long sum = 0;
        for (int tree : trees)
            sum += (tree - mid > 0 ? tree - mid : 0);
        return sum;
    }
}