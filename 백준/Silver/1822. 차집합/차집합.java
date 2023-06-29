import java.io.*;
import java.util.Arrays;

public class Main {
    static String[] l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        l = br.readLine().split(" ");
        int a = Integer.parseInt(l[0]);
        int b = Integer.parseInt(l[1]);

        int[] A = new int[a];
        int[] B = new int[b];
        l = br.readLine().split(" ");
        for (int i = 0; i < a; i++) A[i] = Integer.parseInt(l[i]);
        l = br.readLine().split(" ");
        for (int i = 0; i < b; i++) B[i] = Integer.parseInt(l[i]);

        Arrays.sort(A);
        Arrays.sort(B);

        int cnt = 0;
        for (int j : A)
            if (binarySearch(B, j) == 0) {
                cnt++;
                sb.append(j).append(' ');
            }

        System.out.println(cnt);
        System.out.print(sb);
    }

    private static int binarySearch(int[] B, int target) {
        int l = 0, r = B.length, m = (l + r) / 2;
        while (l < r) {
            if (target == B[m]) return 1;
            else if (B[m] < target) l = m + 1;
            else r = m;
            m = (l + r) / 2;
        }
        return 0;
    }
}